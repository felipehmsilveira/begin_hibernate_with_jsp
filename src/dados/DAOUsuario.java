package dados;

import javax.persistence.EntityManagerFactory;

import classes.Usuario;
import dao.DAOGenerico;

public class DAOUsuario extends DAOGenerico<Usuario>{

	public DAOUsuario(EntityManagerFactory emf) {
		super(emf);
	}

}
