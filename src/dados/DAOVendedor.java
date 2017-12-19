package dados;

import javax.persistence.EntityManagerFactory;

import classes.Vendedor;
import dao.DAOGenerico;

public class DAOVendedor extends DAOGenerico<Vendedor>{

	public DAOVendedor(EntityManagerFactory emf) {
		super(emf);
	}

}
