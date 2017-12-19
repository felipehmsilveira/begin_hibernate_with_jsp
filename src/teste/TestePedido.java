package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import classes.Categoria;
import classes.Cliente;
import classes.Fornecedor;
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
		
		Pedido pedido   = new Pedido();
		Produto produto = new Produto();
		Cliente cliente = new Cliente();
		Categoria categoria = new Categoria();
		Fornecedor fornecedor = new Fornecedor();
		
		String data = "28/08/2010"; //se tirar por ex: 21:19:50 dará java.text.ParseException
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");  //HH:mm:ss
		java.util.Date recebeDataFormatada = null;  
		
		recebeDataFormatada = dataFormatada.parse(data);  
		

		
		fornecedor.setId(18);
		
		fornecedor = fachada.pesquisarFornecedor(fornecedor);
		
		cliente.setId(1);
		
		cliente = fachada.pesquisarCliente(cliente);
		
		System.out.println();
		
		/*produto.setDescricao("Alguma descrição para o produto");
		produto.setQuantidade(4);
		produto.setValorUnitario(1.22);
		produto.setCategoria(categoria);
		produto.setFornecedor(fornecedor);*/
		produto.setId(4);
		
		produto = fachada.pesquisarProduto(produto);
		
	
		
		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		produtoList.add(produto);
		
		
		pedido.setData(recebeDataFormatada);
		pedido.setProduto(produtoList);
		pedido.setValorTotal(1.22);
		pedido.setId(1);
		pedido.setCliente(cliente);
		
		fachada.salvarPedido(pedido);
			
		
	}
}
