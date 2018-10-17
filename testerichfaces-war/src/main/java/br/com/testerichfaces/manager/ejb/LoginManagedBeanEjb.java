package br.com.testerichfaces.manager.ejb;

import javax.ejb.Local;

@Local
public interface LoginManagedBeanEjb {

	boolean isCadastrado(String login, String senha);

}
