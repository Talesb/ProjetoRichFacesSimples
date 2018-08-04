package br.com.testerichfaces.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import br.com.testerichfaces.dao.ClienteDao;
import br.com.testerichfaces.model.Cliente;

@Stateless
public class LoginControllerBean implements LoginController {

	ClienteDao cDao;

	@PostConstruct
	public void init() {
	   // Aqui se Injetaria o EM
	   cDao = new ClienteDao();
	}
	
	public boolean isCadastrado(String email, String senha) {
		Cliente cliente = cDao.findByEmailSenha(email,senha);
		if (cliente != null) {
			return true;
		}
		return false;
	}

}
