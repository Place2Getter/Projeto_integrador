package br.com.generation.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5 , max = 100)
	private String tiposervico;
	
	@NotNull
	@Size(min = 5 , max = 500)
	private String descricao;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String palavrachave;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoServico() {
		return tiposervico;
	}

	public void setTipoServico(String servico) {
		this.tiposervico = servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPalavraChave() {
		return palavrachave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavrachave = palavraChave;
	}
}
