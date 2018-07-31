package br.com.testerichfaces.fakebd;

import java.util.ArrayList;
import java.util.List;

import br.com.testerichfaces.model.Cliente;
import br.com.testerichfaces.model.Livro;

public class FakeDataBase {

	private List<Cliente> clientes;
	private List<Livro> livros;
	
	public FakeDataBase() {
		 populaListas();
	}
	
	public void populaListas() {
		Cliente c1= new Cliente();
		c1.setId(1);
		c1.setNome("Tales");
		c1.setEmail("tales@email");
		c1.setSenha("123456");
		
		Cliente c2= new Cliente();
		c2.setId(2);
		c2.setNome("Isabele");
		c2.setEmail("isabele@email");
		c2.setSenha("123456");
		
		Cliente c3= new Cliente();
		c3.setId(3);
		c3.setNome("Gustavo");
		c3.setEmail("gutavo@email");
		c3.setSenha("123456");
	
		Cliente c4= new Cliente();
		c4.setId(4);
		c4.setNome("Joao");
		c4.setEmail("joao@email");
		c4.setSenha("123456");
		
		
		Livro l1 = new Livro();
		l1.setCod(1);
		l1.setIsbn(145870);
		l1.setNome("As crônicas de narnia");
		l1.setCategoria("Aventura");
		l1.setAutor("Clive Staples Lewis");
		
		Livro l2 = new Livro();
		l2.setCod(2);
		l2.setIsbn(859627);
		l2.setNome("Lusíadas");
		l2.setCategoria("Poesia épica");
		l2.setAutor("Luís de Camões");
		
		Livro l3 = new Livro();
		l3.setCod(3);
		l3.setIsbn(145870);
		l3.setNome("Harry Potter");
		l3.setCategoria("Aventura");
		l3.setAutor("J. K. Rowling.");
		
		Livro l4 = new Livro();
		l4.setCod(4);
		l4.setIsbn(145870);
		l4.setNome("O Silmarillion");
		l4.setCategoria("Aventura");
		l4.setAutor("J.R.R. Tolkein");
		
		Livro l5 = new Livro();
		l5.setCod(4);
		l5.setIsbn(145870);
		l5.setNome("Java Como Programar");
		l5.setCategoria("Programação");
		l5.setAutor("Paul Deitel");
		
		Livro l6 = new Livro();
		l6.setCod(4);
		l6.setIsbn(145870);
		l6.setNome("Design Thinking");
		l6.setCategoria("Design");
		l6.setAutor("Tim Brown");
		
		
		c1.addLivro(l1);
		c2.addLivro(l6);
		c2.addLivro(l4);
		c3.addLivro(l2);
		c4.addLivro(l3);
		c4.addLivro(l5);
		
		l1.setCliente(c1);
		l2.setCliente(c3);
		l3.setCliente(c4);
		l4.setCliente(c2);
		l5.setCliente(c4);
		l6.setCliente(c2);
		
		this.clientes = new ArrayList<Cliente>();
		this.livros  = new ArrayList<Livro>();
		
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		
		livros.add(l1);
		livros.add(l2);
		livros.add(l3);
		livros.add(l4);
		livros.add(l5);
		livros.add(l6);
		
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	
	
	
}
