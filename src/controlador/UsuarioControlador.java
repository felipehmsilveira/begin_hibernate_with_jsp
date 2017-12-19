package controlador;

import classes.Usuario;
import dados.DAOUsuario;
import dao.DAOFactory;

public class UsuarioControlador {

	public void salvar(Usuario usuario) throws Exception {
		DAOUsuario factoryUsuario = DAOFactory.getDAOUsuario();
		
		if ((usuario != null) && (!usuario.getLogin().trim().equals(""))
				&& (!usuario.getEmail().trim().equals(""))
				&& (!usuario.getPassword().trim().equals(""))
				&& (!usuario.getTipo().trim().equals(""))) {
			
			factoryUsuario.insert(usuario);
		} else {
			throw new Exception("User with Problems");
		}
	}

//	public void editar(Usuario usuario) throws Exception {
//
//		DAOUsuario factoryUsuario = DAOFactory.getDAOUsuario();
//		Usuario usuario_search = factoryUsuario.searchByKey(usuario.getId());
//
//		if ((((usuario_search != null) && (!usuario.getNome().trim().equals(""))
//				&& (!usuario.getEmail().trim().equals("")
//						&& (usuario.getSexo() != null) && (usuario.getTipo() != null))))) {
//			factoryUsuario.update(usuario);
//		} else {
//			throw new Exception("Erro ao editar o usuario!");
//		}
//	}
//
//	public void deletar(Usuario usuario) throws Exception {
//
//		DAOUsuario factoryUsuario = DAOFactory.getDAOUsuario();
//		Usuario usuario_search = factoryUsuario.searchByKey(usuario.getId());
//
//		if ((usuario_search != null) && (usuario.getNome().trim().equals(""))) {
//			factoryUsuario.remove(usuario);
//		} else {
//			throw new Exception("Erro ao deletar o usuario");
//		}
//	}
//
//	public ArrayList<Usuario> listar() throws Exception {
//		DAOUsuario factoryUsuario = DAOFactory.getDAOUsuario();
//		ArrayList<Usuario> retorno = (ArrayList<Usuario>) factoryUsuario.getAll();
//		return retorno;
//	}
//
//	public Usuario pesquisar(Usuario usuario) throws Exception {
//		DAOUsuario factoryUsuario = DAOFactory.getDAOUsuario();
//		Usuario usuario_search = factoryUsuario.searchByKey(usuario.getId());
//		if ((usuario_search != null) && (!usuario.getNome().trim().equals(""))) {
//
//			return usuario_search;
//		} else {
//			throw new Exception("Erro ao pesquisar o usuario");
//
//		}
//	}
}
