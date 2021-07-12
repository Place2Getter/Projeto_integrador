package br.com.generation.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.projeto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public List<Usuario> findByNomeUsuarioContainingIgnoreCase(String nomeUsuario);

	public Optional<Usuario> findBynomeUsuario(String nomeUsuario);
	
	public Optional<Usuario> findByEmail(String email);
	
}