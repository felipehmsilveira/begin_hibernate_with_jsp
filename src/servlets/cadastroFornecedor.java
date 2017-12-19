package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import classes.Fornecedor;
import fachada.Fachada;

public class cadastroFornecedor extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		Fachada fachada = Fachada.getInstancia();
		Fornecedor f = new Fornecedor();
		PrintWriter out = response.getWriter();

		String cnpj = request.getParameter("cnpj");
		String nome = request.getParameter("name");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String numero = request.getParameter("numero");
		
		f.setCnpj(cnpj.trim());
		f.setBairro(bairro.trim());
		f.setCep(cep.trim());
		f.setEmail(email.trim());
		f.setTelefone(telefone);
		f.setNome(nome.trim());
		f.setRua(rua.trim());
		f.setCidade(cidade.trim());
		f.setNumero(numero);

		try {
			if(request.getParameter("x") == null ){
			fachada.salvarFornecedor(f);
			response.sendRedirect("fornecedor.jsp");
			}else{
				f.setId(Integer.parseInt(request.getParameter("id")));
				fachada.editarFornecedor(f);
				response.sendRedirect("fornecedor.jsp");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("exception", msg);
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);			
		}
	}

}
