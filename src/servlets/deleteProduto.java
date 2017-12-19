package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Produto;
import fachada.Fachada;

@SuppressWarnings("serial")
public class deleteProduto extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			Fachada fachada = Fachada.getInstancia();
			Produto p = new Produto();
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			p.setId(id);
			
			System.out.println("chegou");
			
			try {
				p = fachada.pesquisarProduto(p);
				fachada.deletarProduto(p);
				response.sendRedirect("produto.jsp");
			} catch (Exception e) {
				String msg = e.getMessage();
				request.setAttribute("exception", msg);
				e.printStackTrace();
				request.getRequestDispatcher("/error.jsp").forward(request, response);	
			}
		}	
}
