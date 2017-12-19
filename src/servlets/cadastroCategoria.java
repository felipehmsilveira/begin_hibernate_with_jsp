package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Categoria;
import fachada.Fachada;

@SuppressWarnings("serial")
public class cadastroCategoria  extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		Fachada fachada = Fachada.getInstancia();
		Categoria c = new Categoria();
		
		String descricao = request.getParameter("descricao");

		c.setDescricao(descricao);
		
		try {
			if(request.getParameter("x") == null){
				fachada.salvarCategoria(c);
				response.sendRedirect("categoria.jsp");
			}else{
				c.setId(Integer.parseInt(request.getParameter("id")));
				fachada.editarCategoria(c);
				response.sendRedirect("categoria.jsp");	
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("exception", msg);
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);	
		}
	}
	
}
