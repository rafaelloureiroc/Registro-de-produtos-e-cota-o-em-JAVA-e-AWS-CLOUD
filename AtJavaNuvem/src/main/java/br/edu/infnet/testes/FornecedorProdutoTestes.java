package br.edu.infnet.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.model.Cotacao;
import br.edu.infnet.model.Fornecedor;
import br.edu.infnet.model.FornecedorProduto;
import br.edu.infnet.model.Produto;

public class FornecedorProdutoTestes {

    public static void main(String[] args) {
        Produto produto = new Produto();
        Fornecedor fornecedor = new Fornecedor();
        FornecedorProduto fornecedorProduto = new FornecedorProduto();

        Cotacao cotacao1 = new Cotacao();
        Cotacao cotacao2 = new Cotacao();
        Cotacao cotacao3 = new Cotacao();
        List<Cotacao> cotacoes = new ArrayList<>();
        cotacao1.setPreco(100.00);
        cotacao2.setPreco(2000.00);
        cotacao3.setPreco(80.00);

        fornecedor.setCotacoes(cotacoes);
        produto.setCotacoes(cotacoes);
        fornecedorProduto.setFornecedor(fornecedor);
        fornecedorProduto.setProduto(produto);
        fornecedorProduto.setQuantidadeProduto(cotacoes.size());
    }

}
