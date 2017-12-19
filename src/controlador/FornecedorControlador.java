package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Fornecedor;
import dados.DAOFornecedor;
import dao.DAOFactory;

public class FornecedorControlador {

	DAOFornecedor factoryFornecedor = DAOFactory.getDAOFornecedor();

	public void salvar(Fornecedor fornecedor) throws Exception {
		
		if(fornecedor != null){
			if(fornecedor.getNome().equals("")){
				throw new Exception("Nome não preenchido");
			} else if (fornecedor.getCnpj().equals("")){
				throw new Exception("Cnpj não preenchido");
			} else if (fornecedor.getEmail().equals("")){
				throw new Exception("E-mail não preenchido");
			} else if (fornecedor.getCidade().equals("")){
				throw new Exception("Cidade não preenchido");
			} else if (fornecedor.getBairro().equals("")){
				throw new Exception("Bairro não preenchido");
			} else if (fornecedor.getNumero().equals("")){
				throw new Exception("Numero do endereço não preenchido");
			} else if (fornecedor.getRua().equals("")){
				throw new Exception("Rua do endereço não preenchido");
			}else {
				factoryFornecedor.insert(fornecedor);
			}
		} 
	}

	public void editar(Fornecedor fornecedor) throws Exception {
		DAOFornecedor factoryFornecedor = DAOFactory.getDAOFornecedor();
		Fornecedor fornecedor_search = factoryFornecedor.searchByKey(fornecedor.getId());
		factoryFornecedor.update(fornecedor);
		/*if (((((fornecedor_search != null) && (!fornecedor.getEmail().trim().equals(""))
				&& (!fornecedor.getNome().trim().equals("")) && (!fornecedor.getCnpj().trim().equals(""))
				&& (fornecedor.getTelefone() != null)
				&& (fornecedor.getSexo() != null))))) {
			

		} else {
			throw new Exception("Erro ao editar produto");
		}*/
	}

	public void deletar(Fornecedor fornecedor) throws Exception {
		DAOFornecedor factoryFornecedor = DAOFactory.getDAOFornecedor();
		Fornecedor fornecedor_search = factoryFornecedor.searchByKey(fornecedor.getId());
		if (((((fornecedor_search != null) && (fornecedor.getEmail().trim().equals(""))
				&& (fornecedor.getNome().trim().equals("")) && (fornecedor.getCnpj().trim().equals(""))
				&& (fornecedor.getTelefone() != null))))) {
			throw new Exception("Erro ao deletar fornecedor!");
		} else {
			factoryFornecedor.remove(fornecedor);
		}

	}

	public ArrayList<Fornecedor> listar() throws Exception {
		DAOFornecedor factoryFornecedor = DAOFactory.getDAOFornecedor();
		try {
			ArrayList<Fornecedor> retorno = (ArrayList<Fornecedor>) factoryFornecedor.getAll();
			return retorno;
		} catch (Exception ex) {
			throw new Exception("Erro ao lista fornecedores" + ex.getMessage());
		}
	}

	public Fornecedor pesquisar(Fornecedor fornecedor) throws Exception {
		DAOFornecedor factoryFornecedor = DAOFactory.getDAOFornecedor();
		Fornecedor fornecedor_search = factoryFornecedor.searchByKey(fornecedor.getId());
		return fornecedor_search;
		/*if (((((fornecedor_search != null) && (fornecedor.getEmail().trim().equals(""))
				&& (fornecedor.getNome().trim().equals("")) && (fornecedor.getCnpj().trim().equals(""))
				&& (fornecedor.getTelefone() != null))))) {
			throw new Exception("Erro ao pesquisar fornecedor");
		} else {
			
		}*/
	}
}
