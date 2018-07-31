package br.com.testerichfaces.model;

public class Livro {

	private Integer cod;
	private Integer isbn;
	private String categoria;
	private String nome;
	private String autor;
	private Cliente cliente;

	public Livro() {

	}

	public Livro(Integer cod, Integer isbn, String categoria, String nome, String autor) {
		this.cod = cod;
		this.isbn = isbn;
		this.categoria = categoria;
		this.nome = nome;
		this.autor = autor;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Livro [cod=" + cod + ", isbn=" + isbn + ", categoria=" + categoria + ", nome=" + nome + ", autor="
				+ autor + "]";
	}
	
	

}
