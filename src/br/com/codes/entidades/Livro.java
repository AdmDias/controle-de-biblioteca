package br.com.codes.entidades;

import java.util.Date;
import java.util.UUID;

public class Livro {
	private String id;
	private String nomeLivro;
	private String nomeAutor;
	private Date dataCriacao;
	private LivroStatus status;
	
	Autor a = new Autor();
	
	public Livro() {
		this.id = UUID.randomUUID().toString();
		this.status = LivroStatus.DISPONIVEL;
		a.setNomeAutor(nomeAutor);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LivroStatus getStatus() {
		return status;
	}
	public void setStatus(LivroStatus status) {
		this.status = status;
	}
}
