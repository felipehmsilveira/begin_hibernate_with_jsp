package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Fornecedor;
import fachada.Fachada;

@SuppressWarnings("serial")
public class editarFornecedor extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Fachada fachada = Fachada.getInstancia();
		Fornecedor f = new Fornecedor();
		
		f.setId(Integer.parseInt(request.getParameter("id")));
		
		System.out.println("Antes do try");
		try {
			f = fachada.pesquisarFornecedor(f);
			System.out.println("Dentro do try");
			request.setAttribute("fornecedor", f);
			RequestDispatcher despachar = request.getRequestDispatcher("/editarFornecedor.jsp");
			despachar.forward(request, response);
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("exception", msg);
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);	
		}
		
	}
}
