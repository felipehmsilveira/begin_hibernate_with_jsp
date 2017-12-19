package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import fachada.Fachada;

public class TesteProduto {
	public static void main (String[] args) throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Fachada fachada = Fachada.getInstancia();
		
		Produto produto = new Produto();
		
		produto.setDescricao("Descrição");
		produto.setTipodoproduto("Entrada");
		
		fachada.salvarProduto(produto);
		
		et.commit();
		em.close();
		emf.close();
			
	}
}
