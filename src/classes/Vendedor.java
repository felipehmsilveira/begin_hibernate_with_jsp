package classes;

import javax.persistence.Entity;


@Entity
public class Vendedor extends Pessoa{

	private Double salario;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
