package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
public class Pedido {
	
	public Pedido(){
		this.produtos = new ArrayList<Produto>();
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	private String iniciodopedido;
	private String fechamentodopedido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToMany
	private List<Produto> produtos;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@ManyToOne
	private Cliente cliente;
	
	public String getIniciodopedido() {
		return iniciodopedido;
	}
	public void setIniciodopedido(String iniciodopedido) {
		this.iniciodopedido = iniciodopedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getFechamentodopedido() {
		return fechamentodopedido;
	}
	public void setFechamentodopedido(String fechamentodopedido) {
		this.fechamentodopedido = fechamentodopedido;
	}
}
