package br.com.generation.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.projeto.model.Tema;
import br.com.generation.projeto.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
public class TemaController {
	
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping()
	private List<Tema> buscarTudo(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	private Tema buscarPorId(@PathVariable long id) {
		return repository.findById(id);
	}
	
	@GetMapping("/buscarservico/{servico}")
	private List<Tema> buscarPorServico(@PathVariable String servico){
		return repository.findByServicoContainingIgnoreCase(servico);
	}
	
	@GetMapping("/buscardescricao/{descricao}")
	private List<Tema> buscaPorDescricao(@PathVariable String descricao) {
		return repository.findByDescricaoContainingIgnoreCase(descricao);
	}
	
	@GetMapping("/buscarhashtag/{hashtag}")
	private List<Tema> buscarPorHashtag(@PathVariable String hashtag){
		return repository.findByHashtagContainingIgnoreCase(hashtag);
	}
	
	@PostMapping("/novo")
	private Tema novoTema(@RequestBody Tema tema) {
		return repository.save(tema);
	}
	
	@PutMapping("/alterar")
	private Tema alterarTema(@RequestBody Tema tema) {
		return repository.save(tema);
	}
	
	@DeleteMapping("/apagar/{id}")
	private Tema apagarTema(@PathVariable long id) {
		return repository.deleteById(id);
	}
}
