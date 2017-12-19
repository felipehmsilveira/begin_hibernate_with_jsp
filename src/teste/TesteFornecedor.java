package teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import classes.Fornecedor;
import fachada.Fachada;

public class TesteFornecedor {

	public static void main(String[] args) throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
	
		Fachada fachada = Fachada.getInstancia();
		
		Fornecedor fornecedor = new Fornecedor();
		
		String data = "28/08/2010"; //se tirar por ex: 21:19:50 dará java.text.ParseException
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");  //HH:mm:ss
		java.util.Date recebeDataFormatada = null;  
				
		recebeDataFormatada = dataFormatada.parse(data);  
		
		fornecedor.setCnpj("09023404402");
		fornecedor.setEmail("email_de_teste@servidor.com");
		fornecedor.setNome("Nome para teste");
		fornecedor.setSexo("M");
		fornecedor.setTelefone("3332-9867");
		fornecedor.setId(18);
		
	
		//fachada.salvarFornecedor(fornecedor);
		//fachada.editarFornecedor(fornecedor);
		//fachada.deletarFornecedor(fornecedor);
		
		//ArrayList<Fornecedor> fornecedor_lista = new ArrayList();
		//System.out.println("Lista de Fornecedores: \n\n"+fornecedor_lista);
		
		//Fornecedor fornecedor_pesquisa = new Fornecedor();
		//fornecedor_pesquisa = fachada.pesquisarFornecedor(fornecedor);
		//System.out.println("Pesquisa de Fornecedor \n\n"+fornecedor_pesquisa);
		
		et.commit();
		em.close();
		emf.close();
	}
}
