package controlador;

import java.util.ArrayList;

import classes.Categoria;
import classes.Pedido;
import dados.DAOCategoria;
import dados.DAOPedido;
import dao.DAOFactory;

public class PedidoControlador {

	DAOPedido factoryPedido = DAOFactory.getDAOPedido();
	
	public void salvar(Pedido pedido) throws Exception{
		
		
		if(pedido.getCliente() == null){
			throw new Exception("Selecione um cliente para este pedido.");
		} else if (pedido.getData() == null || pedido.getData().equals("")){
			throw new Exception("Selecione uma data para este pedido.");
		} else if (pedido.getProduto() == null || pedido.getProduto().size() == 0){
			throw new Exception("Selecione algum produto para este pedido.");
		} else if (pedido.getValorTotal() == null || pedido.getValorTotal().equals("")){
			throw new Exception("Selecione o valor do produto para este pedido.");
		}else{
			factoryPedido.insert(pedido);
		}
	}
	
	public void editar(Pedido pedido) throws Exception{
		Pedido pedido_search    = factoryPedido.searchByKey(pedido.getId());
		if ((pedido_search != null) && (pedido.getData() != null) && (pedido.getProduto() != null) && (pedido.getValorTotal() != null)){
			factoryPedido.update(pedido);
		}else{
			throw new Exception("Erro ao editar pedido");
		}
	}
	
	public void deletar(Pedido pedido) throws Exception{
		Pedido pedido_search = factoryPedido.searchByKey(pedido.getId());
		if  ((pedido_search != null) && (pedido.getData() != null) && (pedido.getProduto() != null) && (pedido.getValorTotal() != null)){
			factoryPedido.remove(pedido);
		}else{
			throw new Exception("Erro ao delegtar pedido");
		}
		
	}
	
	public ArrayList<Pedido> listar() throws Exception{
		ArrayList<Pedido> retorno = (ArrayList<Pedido>) factoryPedido.getAll();
		return retorno;	
	}
	
	public Pedido pesquisar(Pedido pedido) throws Exception{
		Pedido pedido_search = factoryPedido.searchByKey(pedido.getId());
		if ((pedido_search != null) && (pedido.getData() != null) && (pedido.getProduto() != null) && (pedido.getValorTotal() != null)){
			return pedido_search;
		}else{
			throw new Exception("Erro ao pesquisar pedido");
		}
	}
}
