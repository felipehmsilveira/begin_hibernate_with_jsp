package dados;

import javax.persistence.EntityManagerFactory;

import classes.Categoria;
import dao.DAOGenerico;

public class DAOCategoria extends DAOGenerico<Categoria> {

	public DAOCategoria(EntityManagerFactory emf) {
		super(emf);
	}

}
