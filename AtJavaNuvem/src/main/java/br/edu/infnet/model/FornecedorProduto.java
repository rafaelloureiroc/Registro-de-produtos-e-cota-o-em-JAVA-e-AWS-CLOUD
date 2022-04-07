package br.edu.infnet.model;

import javax.persistence.*;

@Entity
@Table(name="fornecedor_produto")
public class FornecedorProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidadeProduto;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToOne
    private Produto produto;

    public FornecedorProduto() {
    }

    public FornecedorProduto(int id, Fornecedor idFornecedor, Produto idProduto) {
        this.id = id;
        this.quantidadeProduto = produto.getQtdEstoque();
        this.fornecedor = idFornecedor;
        this.produto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "FornecedorProduto{" +
                "id=" + id +
                ", quantidadeProduto=" + quantidadeProduto +
                ", fornecedor=" + fornecedor +
                ", produto=" + produto +
                '}';
    }
}
