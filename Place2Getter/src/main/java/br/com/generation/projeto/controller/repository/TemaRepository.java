package br.com.generation.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.projeto.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	public Tema findById(long id); 
	public List<Tema> findByServicoContainingIgnoreCase(String servico);
	public List<Tema> findByDescricaoContainingIgnoreCase(String descricao);
	public List<Tema> findByHashtagContainingIgnoreCase(String hashtag);
	public Tema deleteById(long id);
}
