package teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import classes.Cliente;
import fachada.Fachada;

public class TesteCliente {
	
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
	
		Fachada fachada = Fachada.getInstancia();
		Cliente cliente = new Cliente();	
		
		
		cliente.setDatadenascimento("01/06/94");
		cliente.setEmail("felipe@gmail.com");
		cliente.setPaginanofacebook("www.facebook.com/felipehenrique");
		cliente.setNome("Felipe Henrique");
		cliente.setUsuariodotwitter("www.twittercom/felipehenrique");
		
		JOptionPane.showMessageDialog(null, cliente);
		fachada.salvarCliente(cliente);
		
		et.commit();
		em.close();
		emf.close();
	}
	
	
	
}
