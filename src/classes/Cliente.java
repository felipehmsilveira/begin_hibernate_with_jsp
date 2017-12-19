package classes;


import javax.persistence.Column;
import javax.persistence.Entity;




@Entity
public class Cliente extends Pessoa  {
	
	@Column(nullable = false)
	private String cpf_cnpj;
	private String tipo;
		
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	
	
	
}
 