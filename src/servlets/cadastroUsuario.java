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

import classes.Usuario;
import fachada.Fachada;

/**
 * Servlet implementation class cadastroUsuario
 */
public class cadastroUsuario extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		Fachada fachada = Fachada.getInstancia();

		Usuario usuario = new Usuario();

		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipo");

		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setPassword(password);
		usuario.setTipo(tipo);

		try {
			fachada.salvarUsuario(usuario);
			response.sendRedirect("index.jsp");
		} catch (Exception ex) {
			String message = ex.getMessage();
			request.setAttribute("exeception", message);
			ex.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

}
