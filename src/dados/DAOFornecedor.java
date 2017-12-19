package dados;

import javax.persistence.EntityManagerFactory;

import classes.Fornecedor;
import dao.DAOGenerico;

public class DAOFornecedor extends DAOGenerico<Fornecedor>{

	public DAOFornecedor(EntityManagerFactory emf) {
		super(emf);
		
	}

}
