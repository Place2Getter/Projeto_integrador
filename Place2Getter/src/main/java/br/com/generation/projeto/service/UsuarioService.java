package br.com.generation.projeto.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.generation.projeto.model.Usuario;
import br.com.generation.projeto.model.UsuarioLogin;
import br.com.generation.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	/*	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

        // Verifica se o usuário (email) existe
        if(repository.findByLogin(usuario.getUsuario()).isPresent())
            throw new ResponseStatusException(
                          HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        return Optional.of(repository.save(usuario));
    }*/
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario cadastrarUsuario(Usuario usuario){
		if(repository.findByEmail(usuario.getEmail()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe", null);
		
		// Comando para inserir a biblioteca de criptográfia de senha.
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// Recebendo a senha inserida e atráves do método encoder a senha e
		// criptográfada
		String senhaEnconder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEnconder);
		return repository.save(usuario);
	}	
	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmail(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encoderAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encoderAuth);
				
				user.get().setNome(usuario.get().getNomeUsuario());
				user.get().setToken(authHeader);
				user.get().setSenha(usuario.get().getSenha());
				user.get().setUsuario(usuario.get().getEmail());

				return user;
			}
		}
		return user;
}
	
	public Optional<Usuario> atualizarUsuario(Usuario usuario){

        if(repository.findById(usuario.getId()).isPresent()) {

           
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            String senhaEncoder = encoder.encode(usuario.getSenha());
            usuario.setSenha(senhaEncoder);

            return Optional.of(repository.save(usuario));

        }else {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);

        }
       
    }
}
	
	
