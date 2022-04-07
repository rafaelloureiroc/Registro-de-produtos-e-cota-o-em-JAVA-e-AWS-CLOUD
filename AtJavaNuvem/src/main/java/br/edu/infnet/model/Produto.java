package br.edu.infnet.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nome;

	@OneToMany(mappedBy = "produto")
	private List<Cotacao> cotacoes = new ArrayList<>();

	@Column
	private int qtdEstoque;

	@OneToMany(mappedBy = "produto")
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

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public List<FornecedorProduto> getFornecedorProdutos() {
		return fornecedorProdutos;
	}

	public void setFornecedorProdutos(List<FornecedorProduto> fornecedorProdutos) {
		this.fornecedorProdutos = fornecedorProdutos;
	}

	public List<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public void adicionarItem(FornecedorProduto produto) {
		produto.setProduto(this);
		this.fornecedorProdutos.add(produto);
	}

	public Produto() {
	}

	public Produto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}
