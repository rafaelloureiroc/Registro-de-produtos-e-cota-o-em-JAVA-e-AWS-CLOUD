package br.edu.infnet.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nome;

	// Fornecedor pode dar varias cotacoes
	@OneToMany(mappedBy = "fornecedor")
	private List<Cotacao> cotacoes = new ArrayList<>();

	// Fornecedor pode ter varias formas de contato
	@OneToMany(mappedBy = "fornecedor")
	private List<Contato> contatos = new ArrayList<>();

	// Um fornecedor pode varias cotacoes logo, ele estara sendo associado a varios
	// produtos
	@OneToMany(mappedBy = "fornecedor")
	private List<FornecedorProduto> fornecedorProdutos = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public List<FornecedorProduto> getFornecedorProdutos() {
		return fornecedorProdutos;
	}

	public void setFornecedorProdutos(List<FornecedorProduto> fornecedorProdutos) {
		this.fornecedorProdutos = fornecedorProdutos;
	}

	@Override
	public String toString() {
		return "Fornecedor{" + "id=" + id + ", nome='" + nome + '\'' + ", fornecedorProduto=" + fornecedorProdutos
				+ '}';
	}

	public Fornecedor() {
	}

	public Fornecedor(int id, String nome, List<FornecedorProduto> fornecedorProduto) {
		this.id = id;
		this.nome = nome;
		this.fornecedorProdutos = fornecedorProduto;
	}

	public void adicionarFornecedor(FornecedorProduto fornecedor) {
		fornecedor.setFornecedor(this);
		this.fornecedorProdutos.add(fornecedor);
	}

}
