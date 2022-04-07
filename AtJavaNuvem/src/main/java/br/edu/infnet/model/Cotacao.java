package br.edu.infnet.model;

import javax.persistence.*;

@Entity
@Table(name = "cotacoes")
public class Cotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne
	private Fornecedor fornecedor;

	@Column(nullable = false)
	private Double preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Cotacao{" + "produto=" + produto + ", fornecedor=" + fornecedor + ", preço=" + preco + '}';
	}

	public Cotacao() {
	}

	public Cotacao(int id, Produto produto, Fornecedor fornecedor, Double preço) {
		this.id = id;
		this.produto = produto;
		this.fornecedor = fornecedor;
		this.preco = preço;
	}
}
