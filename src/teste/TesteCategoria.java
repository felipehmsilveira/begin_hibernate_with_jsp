package teste;

import java.sql.Date;
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
import classes.Pessoa;
import classes.Produto;
import dados.DAOCategoria;
import dao.DAOFactory;
import fachada.Fachada;


public class TesteCategoria {

	public static void main(String[] args) throws ParseException {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
	
		Categoria c = new Categoria();
		c.setDescricao("15:50 Testando");
		
		Fachada fachada = Fachada.getInstancia();
		
		try{
			fachada.salvarCategoria(c);
			}catch (Exception ex){
				System.out.println(ex);
			}
		
		//Cliente cliente = new Cliente();
		//Pedido pedido   = new Pedido();
		//Produto produto = new Produto();
		
		//String data = "28/08/2010"; //se tirar por ex: 21:19:50 dará java.text.ParseException
		//SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");  //HH:mm:ss
		//java.util.Date recebeDataFormatada = null;  
		
		//recebeDataFormatada = dataFormatada.parse(data);  
		
/*
		cliente.setCpf_cnpj("09998789865");
		cliente.setDatanasc(recebeDataFormatada);
		cliente.setEmail("exemplo@exemplo.com");
		cliente.setNome("Exemplo");
		cliente.setSexo("M");
		
		try{
		fachada.salvarCliente(cliente);
		}catch (Exception ex){
			System.out.println(ex);
		}
		*/
		///produto.setDescricao("Alguma descrição para o produto");
		//produto.setQuantidade(4);
		//produto.setValorUnitario(1.22);
		
		
		//ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
	//	produtoList.add(produto);
		
		//pedido.setData(recebeDataFormatada);
		//pedido.setProduto(produtoList);
	//pedido.setValorTotal(1.22 * produto.getQuantidade());
		
/*		try{
			fachada.salvarPedido(pedido);
			}catch (Exception ex){
				System.out.println(ex);
			}
*/		
		
		//Pessoa p = new Pessoa();
		/*
		 
		em.persist(c);
		et.commit();
		em.close();
		emf.close();
		*/
		
		/*
		Fornecedor f = new Fornecedor();
		f.setNome("Henrique");
		f.setTelefone("888888888888");
		f.setEmail("luizdidier@outlook.com");
		f.setSexo("Masculino");
		em.persist(f);
		et.commit();
		em.close();
		emf.close();
		*/
		
		//DAOCategoria factoryCategoria = DAOFactory.getDAOCategoria();
		//factoryCategoria.insert(c);
		
		
		
	}

}
