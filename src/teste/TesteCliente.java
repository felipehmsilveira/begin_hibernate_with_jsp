package teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import classes.Cliente;
import fachada.Fachada;

public class TesteCliente {
	
	public static void main(String[] args) throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
	
		Fachada fachada = Fachada.getInstancia();
		Cliente c = new Cliente();
		c.setNome("Fulano do Teste");
		c.setCpf_cnpj("119.548.274.44");
		c.setEmail("testandoAgoraMesmo@outlook.com");
		c.setSexo("Masculino");
		c.setTipo("PF");	
		
		
		fachada.salvarCliente(c);
		
		/*
		c.setNome("Fulano do Teste I EDITAR");
		c.setCpf_cnpj("119.548.274.44");
		c.setEmail("testandoAgoraMesmo@outlook.com");
		c.setSexo("Masculino");
		c.setTipo("PF");
		*/
		
		//fachada.editarCliente(c);
		
		
		
		//fachada.deletarCliente(c);
		
		//ArrayList<Cliente> cliente_lista = fachada.listarCliente();
		//System.out.println ("Lista de Clientes: \n\n"+ cliente_lista);
		
		
		//Cliente cliente_buscar = fachada.pesquisarCliente(c);
		
		//System.out.println("Busca de Clientes: \n\n"+cliente_buscar);
		
		/*et.commit();
		em.close();
		emf.close();*/
	}
	
	
	
}
