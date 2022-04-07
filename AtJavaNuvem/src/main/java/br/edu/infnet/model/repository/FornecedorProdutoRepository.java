package br.edu.infnet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.FornecedorProduto;

@Repository
public interface FornecedorProdutoRepository extends JpaRepository<FornecedorProduto, Integer> {
}
