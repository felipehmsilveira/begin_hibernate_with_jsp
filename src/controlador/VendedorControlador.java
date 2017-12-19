package controlador;

import java.util.ArrayList;

import classes.Produto;
import classes.Vendedor;
import dados.DAOProduto;
import dados.DAOVendedor;
import dao.DAOFactory;

public class VendedorControlador {
	
	DAOVendedor factoryVendedor = DAOFactory.getDAOVendedor();

	public void salvar(Vendedor vendedor) throws Exception{
		if ((vendedor != null) && (vendedor.getEmail() != null) && (!vendedor.getNome().trim().equals("")) && (vendedor.getSalario() != 0)){
			DAOVendedor factoryVendedor = DAOFactory.getDAOVendedor();
			factoryVendedor.insert(vendedor);
		}else{
			throw new Exception("Erro ao salvar vendedor");
		}		
	}
	
	public void editar(Vendedor vendedor) throws Exception{
		DAOVendedor factoryVendedor = DAOFactory.getDAOVendedor();
		Vendedor vendedor_search    = factoryVendedor.searchByKey(vendedor.getId());
		if ((vendedor_search != null) && (vendedor.getEmail() != null) && (!vendedor.getNome().trim().equals("")) && (vendedor.getSalario() != 0)){
			factoryVendedor.update(vendedor);
		}else{
			throw new Exception("Erro ao editar vendedor");
		}
		
	}
	
	public void deletar(Vendedor vendedor) throws Exception{
		DAOVendedor factoryVendedor = DAOFactory.getDAOVendedor();
		Vendedor vendedor_search    = factoryVendedor.searchByKey(vendedor.getId());
		if ((vendedor_search != null) && (vendedor.getEmail() != null) && (!vendedor.getNome().trim().equals("")) && (vendedor.getSalario() != 0)){
			factoryVendedor.remove(vendedor);
		}else{
			throw new Exception("Erro ao remover vendedor");
		}
		
	}
	
	public ArrayList<Vendedor> listar() throws Exception{
		DAOVendedor factoryVendedor = DAOFactory.getDAOVendedor();
		ArrayList<Vendedor> retorno = (ArrayList<Vendedor>) factoryVendedor.getAll();
		return retorno;	
	}
	
	public Vendedor pesquisar(Vendedor vendedor) throws Exception{
		DAOVendedor factoryVendedor = DAOFactory.getDAOVendedor();
		Vendedor vendedor_search = factoryVendedor.searchByKey(vendedor.getId());
		if ((vendedor_search != null) && (vendedor.getEmail() != null) && (!vendedor.getNome().trim().equals("")) && (vendedor.getSalario() != 0)){
			return vendedor_search;
		}else{
			throw new Exception("Erro ao pesquisar produto");
		}
	}	
	
}
