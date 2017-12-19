package classes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
public class Pedido {
	
	public Pedido(){
		setStatus(false);
	}
	
	@Id
	private Integer id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToMany
	//@Cascade(CascadeType.ALL)
	private List<Produto> produto;
	
	private Double valorTotal;
	
	private boolean status;
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}	
	
	public List<Produto> getProduto() {
		return produto;
	}
	
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
