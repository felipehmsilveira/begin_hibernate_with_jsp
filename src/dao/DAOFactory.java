package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dados.DAOCliente;
import dados.DAOPedido;
import dados.DAOProduto;

public abstract class DAOFactory {

	
	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("testePSC");		
	}
	/* Exemple
	public static AlunoDAO getAlunoDAO(){
		AlunoDAO dao = new AlunoDAO(factory);
		return dao;
	} */

	
	
	public static DAOCliente getDAOCliente(){
		DAOCliente dao =  new DAOCliente(factory);
		return dao;
	}
	public static DAOPedido getDAOPedido(){
		DAOPedido dao =  new DAOPedido(factory);
		return dao;
	}
	public static DAOProduto getDAOProduto(){
		DAOProduto dao =  new DAOProduto(factory);
		return dao;
	}
	
}
