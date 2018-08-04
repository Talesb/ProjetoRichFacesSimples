package br.com.testerichfaces.dao;

import java.util.List;

import br.com.testerichfaces.fakebd.FakeDataBase;
import br.com.testerichfaces.model.Cliente;
import br.com.testerichfaces.model.Livro;

public class ClienteDao {

	FakeDataBase db = new FakeDataBase();

	public void insert(Cliente cliente) {
		Integer id = db.getClientes().size() + 1;
		cliente.setId(id);
		db.getClientes().add(cliente);
	}

	public List<Cliente> findAll() {
		return db.getClientes();
	}

	public Cliente findByEmail(String email) {
		for (Cliente clienteaux : db.getClientes()) {
			if (clienteaux.getEmail().equalsIgnoreCase(email)) {
				return clienteaux;
			}
		}
			return null;
	}

	
	public Cliente findByEmailSenha(String email,String senha) {
		for (Cliente clienteaux : db.getClientes()) {
			if (clienteaux.getEmail().equalsIgnoreCase(email)&&(clienteaux.getSenha().equals(senha))){
				return clienteaux;
			}
		}
			return null;
	}
	
	public void insertLivro(Cliente cliente, Livro livro) {
		Cliente clienteAux = findByEmail(cliente.getEmail());
		clienteAux.addLivro(livro);
		Update(clienteAux);
	}

	public void Update(Cliente cliente) {
		for (Cliente clienteaux : db.getClientes()) {
			if (clienteaux.getEmail() == cliente.getEmail()) {
				cliente.setId(clienteaux.getId());
				delete(clienteaux);
				insert(cliente);
			}
		}
	}

	public void delete(Cliente cliente) {
		if (cliente.getId() == null) {
			System.out.println("Cliente ainda não persistido!");
		}
		db.getClientes().remove(cliente);
	}

	public static void main(String[] args) {

		ClienteDao cDao = new ClienteDao();
		Cliente cTeste = new Cliente();

		cTeste.setNome("teste");
		cTeste.setEmail("Teste@email");
		cTeste.setSenha("123");

		cDao.insert(cTeste);

		System.out.println(cDao.findAll().toString());
		
		cDao.delete(cDao.findByEmail("tales@email"));
		
		System.out.println(cDao.findAll().toString());
		
		System.out.println(cDao.findByEmail("isabele@email"));
	
		Cliente cTesteUpdate = new Cliente();
		
		cTesteUpdate.setNome("testeUpdate");
		cTesteUpdate.setEmail("Teste@emailUpdate");
		cTesteUpdate.setSenha("123");
		
		cDao.insert(cTesteUpdate);
		
		Cliente cTesteUpdate2 = new Cliente();
		
		cTesteUpdate2.setNome("testeUpdate2a");
		cTesteUpdate2.setEmail("Teste@emailUpdate");
		cTesteUpdate2.setSenha("1232");
		
		cDao.Update(cTesteUpdate2);
		
		System.out.println(cDao.findAll().toString());
		
		 
		
	}

}
