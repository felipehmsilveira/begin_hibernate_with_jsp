package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import classes.Fornecedor;
import classes.Categoria;
import fachada.Fachada;

public class TesteProduto {
	public static void main (String[] args) throws ParseException{
		
		Fachada fachada = Fachada.getInstancia();
		
		//Pedido pedido   = new Pedido();
		Produto produto = new Produto();
		Categoria c = new Categoria();
		Fornecedor f = new Fornecedor();
		//Cliente cliente = new Cliente();
		
		c.setId(34);
		f.setId(6);
		
		try {
			c = fachada.pesquisarCategoria(c);
			f = fachada.pesquisarFornecedor(f);
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		
		
		/*
		String data = "28/08/2010"; //se tirar por ex: 21:19:50 dará java.text.ParseException
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");  //HH:mm:ss
		java.util.Date recebeDataFormatada = null;  
		*/
		/*recebeDataFormatada = dataFormatada.parse(data);  
		

		cliente.setCpf_cnpj("09998789865");
		cliente.setDatanasc(recebeDataFormatada);
		cliente.setEmail("exemplo@exemplo.com");
		cliente.setNome("Exemplo");
		cliente.setSexo("M");*/
		/*
		try{
		fachada.salvarCliente(cliente);
		}catch (Exception ex){
			System.out.println(ex);
		}*/
		
		produto.setDescricao("Alguma descrição para o produto");
		produto.setQuantidade(4);
		produto.setValorUnitario(1.22);
		produto.setCategoria(c);
		produto.setFornecedor(f);
		
		try{
			fachada.salvarProduto(produto);
			}catch (Exception ex){
				System.out.println(ex);
			}
		
		/*ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		produtoList.add(produto);
		
		pedido.setData(recebeDataFormatada);
		pedido.setProduto(produtoList);
		pedido.setValorTotal(1.22 * produto.getQuantidade());
		pedido.setId(1);
		pedido.setCliente(cliente);
		
		try{
			fachada.salvarPedido(pedido);
			}catch (Exception ex){
				System.out.println(ex);
			}*/
	}
}
