package controlador;

import java.util.ArrayList;

import classes.Pedido;
import dados.DAOPedido;
import dao.DAOFactory;

public class PedidoControlador {

	DAOPedido  factoryPedido = DAOFactory.getDAOPedido();
	
	public void salvar(Pedido pedido) throws Exception{
		
		
		if(pedido.getCliente() == null){
			throw new Exception("Selecione um cliente para este pedido.");
		}else{
			factoryPedido.insert(pedido);
		}
	}
	
	public Pedido pesquisar(Pedido pedido) throws Exception{
		Pedido pedido_search = factoryPedido.searchByKey(pedido.getId());
		if ((pedido_search != null) ){
			return pedido_search;
		}else{
			throw new Exception("Erro ao pesquisar pedido");
		}
	}
	
}
