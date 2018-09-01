package br.com.testerichfaces.repositorio;

import java.util.List;

import org.hibernate.Criteria;

public interface RepositorioGenerico<T> {
	
	List obterPorCriteria(Criteria criteria) throws RuntimeException;
	
	void excluir(T entidade) throws RuntimeException;
	
	void salvar(T entidade) throws RuntimeException;
	
	T obterUnicaEntidadePorCriteria(Criteria criteria) throws RuntimeException;
	
	Criteria obterCriteria(final Class entidade) throws RuntimeException;
}
