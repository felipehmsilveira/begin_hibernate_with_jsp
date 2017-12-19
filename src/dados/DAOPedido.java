package dados;

import javax.persistence.EntityManagerFactory;

import classes.Pedido;
import dao.DAOGenerico;

public class DAOPedido extends DAOGenerico<Pedido> {

	public DAOPedido(EntityManagerFactory emf) {
		super(emf);
	}

}
