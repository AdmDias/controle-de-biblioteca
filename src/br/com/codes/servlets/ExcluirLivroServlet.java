package br.com.codes.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.codes.repositorio.ILivroRepositorio;
import br.com.codes.repositorio.LivroRepositorioMemoria;

@WebServlet("/livros/excluir")
public class ExcluirLivroServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	ILivroRepositorio repositorio = new LivroRepositorioMemoria();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		repositorio.excluir(id);
		resp.sendRedirect("/app");
	}
}
