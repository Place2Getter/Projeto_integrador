package br.com.generation.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.projeto.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	public Postagem findById(long id);
	public List<Postagem> findByCurtidaLessThan(int curtida);
	public List<Postagem> findBytituloPostagemContainingIgnoreCase(String tituloPostagem);
	public List<Postagem> findBydescricaoPostagemContainingIgnoreCase(String descricaoPostagem);
}
