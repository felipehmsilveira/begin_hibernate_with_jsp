package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Categoria;
import fachada.Fachada;

@SuppressWarnings("serial")
public class deleteCategoria extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Fachada fachada = Fachada.getInstancia();
		Categoria c = new Categoria();
		
		c.setId(Integer.parseInt(request.getParameter("id")));
		
		try {
			c = fachada.pesquisarCategoria(c);
			fachada.deletarCategoria(c);
			response.sendRedirect("categoria.jsp");
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("exception", msg);
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);	
		}
		
	}
}
