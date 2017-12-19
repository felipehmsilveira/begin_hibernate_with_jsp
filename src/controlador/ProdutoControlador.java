package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Pedido;
import classes.Produto;
import dados.DAOPedido;
import dados.DAOProduto;
import dao.DAOFactory;

public class ProdutoControlador{

		public void salvar(Produto produto) throws Exception{
			if ((produto != null) && (!produto.getDescricao().trim().equals("")) && (produto.getQuantidade() != 0) && (produto.getValorUnitario() != null)){
				DAOProduto factoryProduto = DAOFactory.getDAOProduto();
				factoryProduto.insert(produto);
			}else{
				throw new Exception("Erro ao salvar produto");
			}
		
	}
	
	public void editar(Produto produto) throws Exception{
		DAOProduto factoryProduto = DAOFactory.getDAOProduto();
		Produto produto_search    = factoryProduto.searchByKey(produto.getId());
		if ((produto_search != null) && (!produto.getDescricao().trim().equals("")) && (produto.getQuantidade() != 0) && (produto.getValorUnitario() != null)){
			factoryProduto.update(produto);
		}else{
			throw new Exception("Erro ao editar produto");
		}
		
	}
	
	public void deletar(Produto produto) throws Exception{
		DAOProduto factoryProduto = DAOFactory.getDAOProduto();
		Produto produto_search    = factoryProduto.searchByKey(produto.getId());
		if ((produto_search != null) && (!produto.getDescricao().trim().equals("")) && (produto.getQuantidade() != 0) && (produto.getValorUnitario() != null)){
			factoryProduto.remove(produto);
		}else{
			throw new Exception("Erro ao deletar produto");
		}
		
	}
	
	public ArrayList<Produto> listar(){
		DAOProduto factoryProduto = DAOFactory.getDAOProduto();
		ArrayList<Produto> retorno = (ArrayList<Produto>) factoryProduto.getAll();
		return retorno;	

	}
	
	public Produto pesquisar(Produto produto) throws Exception{
		DAOProduto factoryProduto = DAOFactory.getDAOProduto();
		Produto produto_search = factoryProduto.searchByKey(produto.getId());
		return produto_search;
		/*
		if ((produto != null) && (!produto.getDescricao().trim().equals("")) && (produto.getQuantidade() != 0) && (produto.getValorUnitario() != null)){
			throw new Exception("Erro ao pesquisar produto");
		}else{

		}
		*/
		
	}
	
}
