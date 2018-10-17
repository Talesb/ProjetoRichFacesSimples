package br.com.testerichfaces.manager.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.testerichfaces.ejb.LoginController;

@Stateless
public class LoginManagedBeanEjbImpl implements LoginManagedBeanEjb {

	@EJB
	private LoginController loginController;

	@Override
	public boolean isCadastrado(String login,String senha) {
		return loginController.isCadastrado(login, senha);

	}

}
