<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.codes.entidades.Livro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Biblioteca</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
		<style>
			a{
				text-decoration: none;
				color: black;
			}
			#in:hover {
  				color: #7DEA76;
			}
			#out:hover {
				color: #EC2222;
			}
			#del:hover {
				color: #22ECEC;
			}
			div{
				margin: 10px;
			}
		</style>
	</head>
	<body>
		<% 
			List<Livro> listaLivrosJSP = new ArrayList<Livro>();
			if(request.getAttribute("listaLivros")!= null){
				listaLivrosJSP = (List<Livro>) request.getAttribute("listaLivros");
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String msgErro = (String) request.getAttribute("Erros");
		%>
		<div class="container" align="center">
			<h4 align="center">Livros da Biblioteca</h4>
			<form action="/app/livros/cadastrar" method="post">
				<div class="form-row">
					 <div class="col">
					 	<input class="form-control mb-2 mr-sm-2 <% if(msgErro != null){ out.println("is-invalid");} %>" type="text" placeholder="Nome do Livro" name="inputNomeLivro"/>
					 </div>
					 <div class="col">
					 	<input class="form-control mb-2 mr-sm-2 <% if(msgErro != null){ out.println("is-invalid");} %>" type="text" placeholder="Nome do Autor" name="inputNomeAutor"/>
					 </div>
					 <div class="col">
					 	<input class="form-control mb-2 mr-sm-2 <% if(msgErro != null){ out.println("is-invalid");} %>" type="text" placeholder="Data (Ex: 02/10/2020)" name="inputDataCriacao"/>
					 </div>
					 <button type="Submit" class="btn btn-primary mb-2">Cadastrar</button>
					 <br>
					 <small> <% if(msgErro != null){ out.println(msgErro);} %> </small>
				</div>
			</form>
			<table class="table">
				<thead align="center">
					<tr>
						<th>#id</th>
						<th>Livro</th>
						<th>Autor</th>
						<th>Data</th>
						<th>Status</th>
						<th>Alterar Status</th>
						<th>Remover</th>
					</tr>
				</thead>
				<% for (Livro livro: listaLivrosJSP) { %>
				<tr>
					<td><% out.println(livro.getId()); %></td>
					<td><%= livro.getNomeLivro() %></td>
					<td><%= livro.getNomeAutor() %></td>
					<td><%= dateFormat.format(livro.getDataCriacao()) %></td>
					<td><%= livro.getStatus().getStatus() %></td>
					<td align="center">
						<a id="in" href="/app/livros/alterarStatus?id=<%=livro.getId()%>&status=disponivel">Disponivel</a>
						<br>
						<a id="out" href="/app/livros/alterarStatus?id=<%=livro.getId()%>&status=emprestado">Emprestado</a>
					</td>
					<td align="center"><a id="del" href="/app/livros/excluir?id=<%=livro.getId()%>" >Excluir</a></td>
				</tr>
				<% } %>
			</table>
		</div>
	</body>
</html>