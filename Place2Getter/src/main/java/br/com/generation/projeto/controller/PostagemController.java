package br.com.generation.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.projeto.model.Postagem;
import br.com.generation.projeto.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	private List<Postagem> listarTudo() {
		return repository.findAll();
	}

	@GetMapping("/buscar/{id}")
	private Postagem buscarPorId(@PathVariable long id) {
		return repository.findById(id);
	}

	@GetMapping("/buscartitulo/{titulo}")
	private List<Postagem> buscarPorTitulo(@PathVariable String titulo){
		return repository.findByTituloContainingIgnoreCase(titulo);
	}
	
	@GetMapping("/buscardescricao/{descricao}")
	private List<Postagem> buscarDescricao(@PathVariable String descricao){
		return repository.findByDescricaoContainingIgnoreCase(descricao);
	}
	
	@GetMapping("/curtidas/{curtidas}")
	private List<Postagem> listaCurtidas(@PathVariable int curtidas){
		return repository.findByCurtidasLessThan(curtidas);
	}
	
	@PostMapping("/novo")
	private Postagem novoPostagem(@RequestBody Postagem postagem) {
		return repository.save(postagem);
	}
	
	@PutMapping("/alterar")
	private Postagem alterarPostagem(@RequestBody Postagem postagem) {
		return repository.save(postagem);
	}
	
	@DeleteMapping("apagar/{id}")
	private Postagem apagarPostagem(@PathVariable long id) {
		return repository.deleteById(id);
	}
}
