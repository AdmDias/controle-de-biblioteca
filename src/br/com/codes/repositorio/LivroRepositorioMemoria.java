package br.com.codes.repositorio;

import java.util.ArrayList;
import java.util.List;
import br.com.codes.entidades.*;

public class LivroRepositorioMemoria implements ILivroRepositorio{

	private static List<Livro> livros = new ArrayList<Livro>();
	
	@Override
	public List<Livro> buscarTodos() {
		return livros;
	}

	@Override
	public Livro buscarPorId(String id) throws IllegalArgumentException{
		for(Livro livro: livros) {
			if(id.equals(livro.getId())) {
				return livro;
			}
		}
		throw new IllegalArgumentException("ID inexistente!");
	}

	@Override
	public Livro cadastrar(Livro livro) throws IllegalArgumentException{
		if(livro.getNomeLivro() == null || livro.getNomeLivro().isEmpty()) {
			throw new IllegalArgumentException("Nome do livro nao pode ser vazio!");
		}else if(livro.getNomeLivro().length() < 10) {
			throw new IllegalArgumentException("Nome do livro nao pode ser vazio!");
		}
		if(livro.getNomeAutor() == null || livro.getNomeAutor().isEmpty()) {
			throw new IllegalArgumentException("Nome do Autor nao pode ser vazio!");
		}else if(livro.getNomeAutor().length() < 10) {
			throw new IllegalArgumentException("Nome do Autor nao pode ser vazio!");
		}
		if(livro.getDataCriacao() == null) {
			throw new IllegalArgumentException("Insira data de criacao!");
		}
		livros.add(livro);
		return livro;
	}

	@Override
	public void alterarStatus(String id, String status) throws IllegalArgumentException {
		Livro livro = this.buscarPorId(id);
		switch(status) {
			case "disponivel":
				livro.setStatus(LivroStatus.DISPONIVEL);
				break;
			case "emprestado":
				livro.setStatus(LivroStatus.EMPRESTADO);
				break;
			default:
				throw new IllegalArgumentException("Status Invalido!");
		}
	}

	@Override
	public void excluir(String id) {
		for(int i=0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getId().equals(id)) {
				livros.remove(i);
			}
		}
	}
}
