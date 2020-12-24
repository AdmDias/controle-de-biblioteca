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
@WebServlet("/livros/cadastrar")
public class CadastrarLivroServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ILivroRepositorio repositorio = new LivroRepositorioMemoria();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeLivro = req.getParameter("inputNomeLivro");
		String nomeAutor = req.getParameter("inputNomeAutor");
		String data = req.getParameter("inputDataCriacao");
		
		Livro livro = new Livro();
		livro.setNomeLivro(nomeLivro);
		livro.setNomeAutor(nomeAutor);

		try {
		    Date dateCriacao = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		    livro.setDataCriacao(dateCriacao);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		try {
			 repositorio.cadastrar(livro);
			 resp.sendRedirect("/app");
		}catch (IllegalArgumentException e) {
			req.setAttribute("Erros", e.getMessage());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/app");
			dispatcher.forward(req, resp);
		}
	}
}
