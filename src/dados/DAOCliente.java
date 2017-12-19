package dados;

import javax.persistence.EntityManagerFactory;

import classes.Cliente;
import dao.DAOGenerico;

public class DAOCliente extends DAOGenerico<Cliente> {

	public DAOCliente(EntityManagerFactory emf) {
		super(emf);
	}
}
