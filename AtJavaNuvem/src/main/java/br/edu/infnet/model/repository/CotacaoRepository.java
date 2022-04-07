package br.edu.infnet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.Cotacao;
import br.edu.infnet.model.Fornecedor;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Integer> {
}
