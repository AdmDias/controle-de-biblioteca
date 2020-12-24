package br.com.codes.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.codes.entidades.Livro;
import br.com.codes.repositorio.ILivroRepositorio;
import br.com.codes.repositorio.LivroRepositorioMemoria;

@WebServlet("/livros/listar")
public class ListarLivrosServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ILivroRepositorio repositorio = new LivroRepositorioMemoria();
	
	
	@Override
	public void init() throws ServletException {
		Livro livro1 = new Livro();
		livro1.setNomeLivro("God of War(vol.1)");
		livro1.setNomeAutor("Matthew Stover");

		String sDate1="01/11/2012";
		try {
		    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		    livro1.setDataCriacao(date1);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		repositorio.cadastrar(livro1);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listaLivros", repositorio.buscarTodos());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
}
