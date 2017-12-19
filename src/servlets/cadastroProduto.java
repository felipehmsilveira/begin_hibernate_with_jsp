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
import classes.Fornecedor;
import classes.Produto;
import fachada.Fachada;

public class cadastroProduto extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		Fachada fachada = Fachada.getInstancia();
		Fachada fach = Fachada.getInstancia();
		
		Produto p = new Produto();

		String descricao = request.getParameter("descricao");
		String vU = request.getParameter("valorUnitario");
		String qtd = request.getParameter("quantidade");
		String fornId = request.getParameter("fornecedor");
		String cateId = request.getParameter("categoria");
		
		int fornecedorID = Integer.parseInt(fornId);
		int categoriaID = Integer.parseInt(cateId);
		
		Fornecedor f = new Fornecedor();
		Categoria c = new Categoria();
		
		f.setId(fornecedorID);
		c.setId(categoriaID);
		
		try {
			c = fachada.pesquisarCategoria(c);
			f = fachada.pesquisarFornecedor(f);
		} catch (Exception e1) {
			String msg = e1.getMessage();
			request.setAttribute("exception", msg);
			e1.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);		
		}
		
		System.out.println("FORNECEDOR " + f.getNome());
		System.out.println("Categoria " + c.getDescricao());
		
		int quantidade = Integer.parseInt(qtd);
		double valorUnitario = Double.parseDouble(vU);
		
		p.setDescricao(descricao);
		p.setQuantidade(quantidade);
		p.setValorUnitario(valorUnitario);
		p.setFornecedor(f);
		p.setCategoria(c);
		
		try {
			if(request.getParameter("x") == null){
			fach.salvarProduto(p);
			response.sendRedirect("produto.jsp");
			}else{
				p.setId(Integer.parseInt(request.getParameter("id")));
				fach.editarProduto(p);
				response.sendRedirect("produto.jsp");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			request.setAttribute("exception", msg);
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);	
		}
}
}