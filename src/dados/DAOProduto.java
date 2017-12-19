package dados;

import javax.persistence.EntityManagerFactory;

import classes.Produto;
import dao.DAOGenerico;

public class DAOProduto extends DAOGenerico<Produto>{

	public DAOProduto(EntityManagerFactory emf) {
		super(emf);
	}

}
