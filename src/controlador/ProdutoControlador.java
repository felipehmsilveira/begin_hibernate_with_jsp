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
		if (produto != null){
			DAOProduto factoryProduto = DAOFactory.getDAOProduto();
			factoryProduto.insert(produto);
		}else{
			throw new Exception("Erro ao salvar produto");
		}
	}
	
	public Produto pesquisar(Produto produto) throws Exception{
		DAOProduto factoryProduto = DAOFactory.getDAOProduto();
		Produto produto_search = factoryProduto.searchByKey(produto.getId());
		if (produto_search == null ){
			throw new Exception("Erro ao pesquisar produto");
		}else{
			return produto_search;
		}
	}
	
}
