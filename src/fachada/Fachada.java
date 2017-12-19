package fachada;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import controlador.ClienteControlador;
import controlador.PedidoControlador;
import controlador.ProdutoControlador;

public class Fachada {
	
	private static Fachada instancia;
	private final ClienteControlador ctrlCliente;
	private final PedidoControlador ctrlPedido;
	private final ProdutoControlador ctrlProduto;

	private Fachada() {
		ctrlCliente = new ClienteControlador();
		ctrlPedido = new PedidoControlador();
		ctrlProduto = new ProdutoControlador();
	}
	
	public static Fachada getInstancia(){
		if(instancia==null)
			instancia = new Fachada();
		return instancia;
	}
	
	public void salvarCliente(Cliente cliente) throws Exception{
		ctrlCliente.salvar(cliente);
	}
	
	public void salvarPedido(Pedido pedido) throws Exception{
		ctrlPedido.salvar(pedido);
	}
	
	public void salvarProduto(Produto produto) throws Exception{
		ctrlProduto.salvar(produto);
	}
	
	public ArrayList<Cliente> listarCliente() throws Exception{
		return ctrlCliente.listar();
	}
	
	public Cliente pesquisarCliente(Cliente cliente) throws Exception{
		return ctrlCliente.pesquisar(cliente);
	}
	
	public Produto pesquisarProduto(Produto produto) throws Exception{
		return ctrlProduto.pesquisar(produto);
	}
}


