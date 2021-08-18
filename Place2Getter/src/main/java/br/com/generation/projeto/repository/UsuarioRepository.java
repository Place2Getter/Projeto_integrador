package br.com.generation.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.projeto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);

	public Optional<Usuario> findByNome(String nome);
	
	public Optional<Usuario> findByUsuario(String usuario);
	
}