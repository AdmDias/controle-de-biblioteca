package br.com.codes.repositorio;

import java.util.List;
import br.com.codes.entidades.*;

public interface ILivroRepositorio {
	
	public List<Livro> buscarTodos();
	
	public Livro buscarPorId(String id);
	
	public Livro cadastrar(Livro livro);
	
	public void alterarStatus(String id, String status) throws IllegalArgumentException;
	
	public void excluir(String id);
}
