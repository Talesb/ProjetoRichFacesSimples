package br.com.testerichfaces.ejb;

import javax.ejb.Stateless;

import br.com.testerichfaces.dao.ClienteDao;
import br.com.testerichfaces.model.Cliente;

@Stateless
public class LoginControllerBean implements LoginController {

	// Aqui se Injetaria o EM
	ClienteDao cDao = new ClienteDao();

	public boolean isCadastrado(String email, String senha) {
		Cliente cliente = cDao.findByEmail(email);
		if (cliente.getSenha() == senha) {
			return true;
		} else {
			return false;
		}
	}

}
