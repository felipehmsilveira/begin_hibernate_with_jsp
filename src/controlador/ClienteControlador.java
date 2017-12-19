package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Cliente;
import classes.Produto;
import dados.DAOCliente;
import dados.DAOProduto;
import dao.DAOFactory;

public class ClienteControlador {
	DAOCliente factoryCliente = DAOFactory.getDAOCliente();

	public void salvar(Cliente cliente) throws Exception {
		factoryCliente.insert(cliente);
			
	}

	public ArrayList<Cliente> listar() throws Exception {
		ArrayList<Cliente> retorno = (ArrayList<Cliente>)
		factoryCliente.getAll();
		return retorno;
	}
	
	public Cliente pesquisar(Cliente cliente) throws Exception{
		Cliente cliente_search = factoryCliente.searchByKey(cliente.getId());
		if (cliente_search == null ){
			throw new Exception("Erro ao pesquisar produto");
		}else{
			return cliente_search;
		}
	}

}
