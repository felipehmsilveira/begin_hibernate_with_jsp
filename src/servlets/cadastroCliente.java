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
import javax.swing.JOptionPane;

import classes.Cliente;
import fachada.Fachada;

public class cadastroCliente extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		Fachada fachada = Fachada.getInstancia();
		Cliente c = new Cliente();

		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("name");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String tipo = request.getParameter("tipo");
		String telefone = request.getParameter("telefone");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String numero = request.getParameter("numero");
		
		c.setCpf_cnpj(cpf.trim());
		c.setNome(nome.trim());
		
		if(sexo.equals("1"))
			c.setSexo("Masculino");
		else
			c.setSexo("Feminino");
		
		if(tipo.equals(1))
			c.setTipo("PJ");
		else
			c.setTipo("PF");
			
		
		c.setEmail(email.trim());
		c.setTelefone(telefone);
		c.setCep(cep.trim());
		c.setRua(rua.trim());
		c.setBairro(bairro.trim());
		c.setCidade(cidade.trim());
		c.setNumero(numero.trim());
		
		try {
			if(request.getParameter("x") == null){
			fachada.salvarCliente(c);
			response.sendRedirect("cliente.jsp");
			}else{
				c.setId(Integer.parseInt(request.getParameter("id")));
				fachada.editarCliente(c);
				response.sendRedirect("cliente.jsp");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("exception", msg);
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);	
		}
	}
}
