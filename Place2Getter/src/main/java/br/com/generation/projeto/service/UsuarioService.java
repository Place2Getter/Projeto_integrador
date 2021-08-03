package br.com.generation.projeto.service;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.mail.MessagingException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.generation.projeto.email.SmtpEmailSender;
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
	
	@Autowired
	public SmtpEmailSender smtpEmailSender;
	
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		if(repository.findByUsuario(usuario.getUsuario()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe", null);
		
		// Comando para inserir a biblioteca de criptográfia de senha.
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// Recebendo a senha inserida e atráves do método encoder a senha e
		// criptográfada
		String senhaEnconder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEnconder);
		String name = usuario.getNome();
		try {
			smtpEmailSender.send(usuario.getUsuario(), "Olá " + name + " Seja bem vindo a Place2Getter", " <h2>Estamos muito felizes por você fazer parte do nosso projeto.</h2>"
					+ "<h4>Nossa equipe se orgulha em poder oferecer aos "
					+ "nosso jovens trocas continuas de conhecimento e o que há "
					+ "de melhor na arte de educar, para que eles possam construir "
					+ "um futuro promissor e cheio de conquistas!!!!</h4>");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repository.save(usuario);
	}	
	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encoderAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encoderAuth);
				
				user.get().setId(usuario.get().getId());
				user.get().setNome(usuario.get().getNome());
				user.get().setToken(authHeader);
				user.get().setFoto(usuario.get().getFoto());
				user.get().setTipo(usuario.get().getTipo());

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
	
	
