package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dados.DAOCategoria;
import dados.DAOCliente;
import dados.DAOFornecedor;
import dados.DAOPedido;
import dados.DAOProduto;
import dados.DAOUsuario;
import dados.DAOVendedor;


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

	
	public static DAOCategoria getDAOCategoria(){
		DAOCategoria dao =  new DAOCategoria(factory);
		return dao;
	}
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
	public static DAOVendedor getDAOVendedor(){
		DAOVendedor dao =  new DAOVendedor(factory);
		return dao;
	}
	public static DAOUsuario getDAOUsuario(){
		DAOUsuario dao =  new DAOUsuario(factory);
		return dao;
	}
	public static DAOFornecedor getDAOFornecedor(){
		DAOFornecedor dao =  new DAOFornecedor(factory);
		return dao;
	}
}
