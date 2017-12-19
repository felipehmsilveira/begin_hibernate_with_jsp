package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import fachada.Fachada;

public class TestePedido {
	public static void main (String[] args) throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Fachada fachada = Fachada.getInstancia();
		
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		List<Produto> produtos = new ArrayList<Produto>();
		Produto produto = new Produto();

		//OBS: VERIFICAR NO BANCO O ID DO CLIENTE E O ID DO PRODUTO CERTO PARA NÃO HAVER ERRO.
		
		cliente.setId(5);
		cliente = fachada.pesquisarCliente(cliente);
		
		JOptionPane.showMessageDialog(null, cliente.getNome());
		
	 	produto.setId(1);
		produto = fachada.pesquisarProduto(produto);

		pedido.setCliente(cliente);
		pedido.setFechamentodopedido("19:29");
		pedido.setIniciodopedido("18:20");
		pedido.setProdutos(produtos);
		
		fachada.salvarPedido(pedido);
		et.commit();
		em.close();
		emf.close();
	}
}
