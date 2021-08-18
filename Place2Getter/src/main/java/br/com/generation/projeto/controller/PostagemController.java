package br.com.generation.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import br.com.generation.projeto.service.PostagemService;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@Autowired
	private PostagemService postagemService;

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
	
	@PostMapping("/novo")
	private Postagem novoPostagem(@RequestBody Postagem postagem) {
		return repository.save(postagem);
	}
	
	@PutMapping("/alterar")
	private Postagem alterarPostagem(@RequestBody Postagem postagem) {
		return repository.save(postagem);
	}
	
	@PutMapping("/curtir/{id}")
	private ResponseEntity<Postagem> putCurtirPostageId (@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK)
				.body(postagemService.curtir(id));
	}
	
	@PutMapping("/descurtir/{id}")
	private ResponseEntity<Postagem> putDescurtirPostageId (@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK)
				.body(postagemService.descurtir(id));
	}
	
	@DeleteMapping("apagar/{id}")
	private Postagem apagarPostagem(@PathVariable long id) {
		return repository.deleteById(id);
	}
}
