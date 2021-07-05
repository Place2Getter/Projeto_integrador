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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping("/listapostagem")
	public List<Postagem> listaPostagem(){
		return postagemRepository.findAll();
	}
	
	@GetMapping("/postagem/{id}")
	public Postagem listarId(@PathVariable long id) {
		return postagemRepository.findById(id);
	}
	
	@GetMapping("/curtida/{curtida}")
	public List<Postagem> buscarCurtida(@PathVariable int curtida) {
		return postagemRepository.findByCurtidaLessThan(curtida);
	}
	
	@GetMapping("/titulopostagem/{tituloPostagem}")
	public List<Postagem> buscartituloPostagem (@PathVariable String tituloPostagem) {
		return postagemRepository.findBytituloPostagemContainingIgnoreCase(tituloPostagem);
	}
	
	@GetMapping("/descricaoPostagem/{descricaoPostagem}")
	public List<Postagem> buscardescricaoPostagem (@PathVariable String descricaoPostagem) {
		return postagemRepository.findBydescricaoPostagemContainingIgnoreCase(descricaoPostagem);
	}
	
	@PostMapping("/novo")
	public Postagem novaPostagem(@RequestBody Postagem postagem) {
		return postagemRepository.save(postagem);
	}
	
	@PutMapping("/alterar")
	public Postagem alterarPostagem(@RequestBody Postagem postagem) {
		return postagemRepository.save(postagem);
	}
	
	@DeleteMapping("/apagar/{id}")
	public void deletePostagem(@PathVariable long id) {
		postagemRepository.deleteById(id);
	
	}
}
