package br.com.testerichfaces.ejb;

import javax.ejb.Local;

@Local
public interface LoginController {

	boolean isCadastrado(String Email, String Senha);

}
