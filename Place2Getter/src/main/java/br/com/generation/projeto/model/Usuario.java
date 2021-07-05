package br.com.generation.projeto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;



@Entity
@Table(name = "tb_usuario")	
public class Usuario {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3 , max = 255)
	private String nomeUsuario;
	
	@NotNull
	@Size(min = 5 , max = 255)
	private String email;
	
	@NotNull
	@Size(min = 5 , max = 255)
	private String senha;

	@NotNull
	@Size(min = 5 , max = 500)
	private String imagemUsuario;
	
	@NotNull
	private boolean perfilUsuario;
	
	@NotNull
	@Size(min = 5 , max = 255)
	private String ocupacaoProfissao;
	
	@NotNull
	@Size(min = 5 , max = 500)
	private String habilidades;
	
	//Relacionamento da Postagem
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("usuario")
	private List<Postagem> postagem;
	
	
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getImagemUsuario() {
		return imagemUsuario;
	}

	public void setImagemUsuario(String imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}

	public boolean isPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(boolean perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public String getOcupacaoProfissao() {
		return ocupacaoProfissao;
	}

	public void setOcupacaoProfissao(String ocupacaoProfissao) {
		this.ocupacaoProfissao = ocupacaoProfissao;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}	

		
}
