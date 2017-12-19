package controlador;

import java.util.ArrayList;

import classes.Categoria;
import dados.DAOCategoria;
import dao.DAOFactory;

public class CategoriaControlador {

	public void salvar(Categoria categoria) throws Exception {

		if ((categoria != null) && (!categoria.getDescricao().trim().equals(""))) {
			DAOCategoria factoryCategoria = DAOFactory.getDAOCategoria();
			factoryCategoria.insert(categoria);
		} else {
			throw new Exception("Error");
		}
	}

	public void editar(Categoria categoria) throws Exception {

		DAOCategoria factoryCategoria = DAOFactory.getDAOCategoria();
		Categoria categoria_search = factoryCategoria.searchByKey(categoria.getId());
		if ((categoria_search != null) && (!categoria.getDescricao().trim().equals(""))) {
			factoryCategoria.update(categoria);
		} else {
			throw new Exception("Error");
		}
	}

	public void deletar(Categoria categoria) throws Exception {

		DAOCategoria factoryCategoria = DAOFactory.getDAOCategoria();
		Categoria categoria_search = factoryCategoria.searchByKey(categoria.getId());
		if ((categoria_search != null) && (!categoria.getDescricao().trim().equals(""))) {
			factoryCategoria.remove(categoria);
		} else {
			throw new Exception("Error");
		}
	}

	public ArrayList<Categoria> listar() throws Exception {
		DAOCategoria factoryCategoria = DAOFactory.getDAOCategoria();
		ArrayList<Categoria> retorno = (ArrayList<Categoria>) factoryCategoria.getAll();
		return retorno;
	}

	public Categoria pesquisar(Categoria categoria) throws Exception {
		DAOCategoria factoryCategoria = DAOFactory.getDAOCategoria();
		Categoria categoria_search = factoryCategoria.searchByKey(categoria.getId());
		return categoria_search;
		/*if ((categoria_search != null) && (!categoria.getDescricao().trim().equals(""))) {
			return categoria_search;
		} else {
			throw new Exception("Error");
		}*/
	}

}
