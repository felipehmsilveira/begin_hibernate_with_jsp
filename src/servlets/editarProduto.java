package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Produto;
import fachada.Fachada;

@SuppressWarnings("serial")
public class editarProduto extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Fachada fachada = Fachada.getInstancia();
		Produto p = new Produto();
		
		p.setId(Integer.parseInt(request.getParameter("id")));
		
		System.out.println("Antes do try");
		try {
			p = fachada.pesquisarProduto(p);
			System.out.println("Dentro do try");
			request.setAttribute("produto", p);
			RequestDispatcher despachar = request.getRequestDispatcher("/editarProduto.jsp");
			despachar.forward(request, response);
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("exception", msg);
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);	
		}
		
	}
}
