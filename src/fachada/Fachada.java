package fachada;

import java.util.ArrayList;

import classes.Categoria;
import classes.Cliente;
import classes.Fornecedor;
import classes.Pedido;
import classes.Produto;
import classes.Usuario;
import classes.Vendedor;
import controlador.CategoriaControlador;
import controlador.ClienteControlador;
import controlador.FornecedorControlador;
import controlador.PedidoControlador;
import controlador.ProdutoControlador;
import controlador.UsuarioControlador;
import controlador.VendedorControlador;

public class Fachada {
	
	private static Fachada instancia;
	private final CategoriaControlador ctrlCategoria;
	private final ClienteControlador ctrlCliente;
	private final PedidoControlador ctrlPedido;
	private final ProdutoControlador ctrlProduto;
	private final VendedorControlador ctrlVendedor;
	private final UsuarioControlador ctrlUsuario;
	private final FornecedorControlador ctrlFornecedor;

	private Fachada() {
		ctrlCategoria = new CategoriaControlador();
		ctrlCliente = new ClienteControlador();
		ctrlPedido = new PedidoControlador();
		ctrlProduto = new ProdutoControlador();
		ctrlVendedor = new VendedorControlador();
		ctrlUsuario = new UsuarioControlador();
		ctrlFornecedor = new FornecedorControlador();
	}
	
	public static Fachada getInstancia(){
		if(instancia==null)
			instancia = new Fachada();
		return instancia;
	}
	
	//CATEGORIA
	public void salvarCategoria(Categoria categoria) throws Exception{
		ctrlCategoria.salvar(categoria);
	}
	
	public void editarCategoria(Categoria categoria) throws Exception{
		ctrlCategoria.editar(categoria);
	}
	
	public void deletarCategoria(Categoria categoria) throws Exception{
		ctrlCategoria.deletar(categoria);
	}

	public ArrayList<Categoria> listarCategoria() throws Exception {
		return ctrlCategoria.listar();
	}

	public Categoria pesquisarCategoria(Categoria categoria) throws Exception {
		return ctrlCategoria.pesquisar(categoria);
	}
	//FIM CATEGORIA
	
	//CLIENTE
	public void salvarCliente(Cliente cliente) throws Exception{
		ctrlCliente.salvar(cliente);
	}
	
	public void editarCliente(Cliente cliente) throws Exception{
		ctrlCliente.editar(cliente);
		
	}
	
	public void deletarCliente(Cliente cliente) throws Exception{
		ctrlCliente.deletar(cliente);
	}
	
	public ArrayList<Cliente> listarCliente() throws Exception{
		return ctrlCliente.listar();
	}
	
	public Cliente pesquisarCliente(Cliente cliente) throws Exception{
		return ctrlCliente.pesquisar(cliente);
	}
	// FIM CLIENTE

	// FORNECEDOR
	public void salvarFornecedor(Fornecedor fornecedor) throws Exception {
		ctrlFornecedor.salvar(fornecedor);
	}

	public void editarFornecedor(Fornecedor fornecedor) throws Exception {
		ctrlFornecedor.editar(fornecedor);
	}

	public void deletarFornecedor(Fornecedor fornecedor) throws Exception {
		ctrlFornecedor.deletar(fornecedor);
	}

	public ArrayList<Fornecedor> listarFornecedor() throws Exception {
		return ctrlFornecedor.listar();
	}
	public Fornecedor pesquisarFornecedor(Fornecedor fornecedor) throws Exception {
		return ctrlFornecedor.pesquisar(fornecedor);
	}
	// FIM FORNECEDOR

	// PEDIDO
	public void salvarPedido(Pedido pedido) throws Exception {
		ctrlPedido.salvar(pedido);
	}

	public void editarPedido(Pedido pedido) throws Exception {
		ctrlPedido.editar(pedido);
	}

	public void deletarPedido(Pedido pedido) throws Exception {
		ctrlPedido.deletar(pedido);
	}

	public ArrayList<Pedido> listarPedido() throws Exception {
		return ctrlPedido.listar();
	}

	public Pedido pesquisarPedido(Pedido pedido) throws Exception {
		return ctrlPedido.pesquisar(pedido);
	}
	// FIM PEDIDO

	// PRODUTO
	public void salvarProduto(Produto produto) throws Exception {
		ctrlProduto.salvar(produto);
	}

	public void editarProduto(Produto produto) throws Exception {
		ctrlProduto.editar(produto);
	}

	public void deletarProduto(Produto produto) throws Exception {
		ctrlProduto.deletar(produto);
	}

	public ArrayList<Produto> listarProduto() throws Exception {
		return ctrlProduto.listar();
	}

	public Produto pesquisarProduto(Produto produto) throws Exception {
		return ctrlProduto.pesquisar(produto);
	}
	//FIM PRODUTO
	
	//USUARIO
	public void salvarUsuario(Usuario usuario) throws Exception{
		ctrlUsuario.salvar(usuario);
	}
	
	public void editarUsuario(Usuario usuario){
		
	}
	
	public void deletarUsuario(Usuario usuario){
		
	}

	public ArrayList<Usuario> listarUsuario() {
		ArrayList<Usuario> retorno = new ArrayList();
		return retorno;
	}
	
	public Usuario pesquisarUsuario(Usuario usuario){
		return usuario;
	}
	// FIM USUARIO

	// VENDEDOR
	public void salvarVendedor(Vendedor vendedor) throws Exception {
		ctrlVendedor.salvar(vendedor);
	}

	public void editarVendedor(Vendedor vendedor) throws Exception {
		ctrlVendedor.editar(vendedor);
	}

	public void deletarVendedor(Vendedor vendedor) throws Exception {
		ctrlVendedor.deletar(vendedor);
	}

	public ArrayList<Vendedor> listarVendedor() throws Exception {
		return ctrlVendedor.listar();
	}
	
	public Vendedor pesquisarVendedor(Vendedor vendedor){
		return vendedor;
	}
	//FIM VENDEDOR
}


