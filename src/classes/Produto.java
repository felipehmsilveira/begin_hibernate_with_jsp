package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	private String tipodoproduto;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipodoproduto() {
		return tipodoproduto;
	}
	public void setTipodoproduto(String tipodoproduto) {
		this.tipodoproduto = tipodoproduto;
	}
	
}
