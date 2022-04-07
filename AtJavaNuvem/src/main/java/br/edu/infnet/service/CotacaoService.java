package br.edu.infnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.Cotacao;
import br.edu.infnet.model.Fornecedor;
import br.edu.infnet.model.repository.CotacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CotacaoService {

	@Autowired
	CotacaoRepository cotacaoRepository;

	public List<Cotacao> listAll() {
		return cotacaoRepository.findAll();
	}

	/// POST
	public String save(Cotacao cotacao) throws Exception {
		String msg = "";
		try {
			cotacaoRepository.save(cotacao);
			msg = "Fornecedor cadastrado.";
		} catch (Exception e) {
			msg = "Erro ao cadastrar fornecedor.";
			e.getMessage();
		}
		return msg;
	}

	/// GET
	public Optional<Cotacao> getById(int id) {
		Optional<Cotacao> cotacao = cotacaoRepository.findById(id);
		if (cotacao.isPresent()) {
			return cotacao;
		}
		return null;
	}

	/// PATCH/PUT
	public String atualizar(int id, Cotacao cotacao) {
		String msg = "";
		Cotacao cotacaoAtualizado = cotacaoRepository.findById(id).get();

		if (cotacaoAtualizado != null) {
			cotacaoAtualizado.setId(cotacao.getId());
			cotacaoAtualizado.setPreco(cotacao.getPreco());
			cotacaoAtualizado.setProduto(cotacao.getProduto());
			

			cotacaoRepository.save(cotacaoAtualizado);
			msg = "cotacao cadastrado.";
			return msg;
		} else {
			msg = "Erro ao cadastrar cotacao.";
		}

		return msg;
	}

	/// DELETE
	public String deleteById(int id) throws Exception {
		String msg = "";
		try {
			cotacaoRepository.deleteById(id);
			msg = "cotacao cadastrado.";
			return msg;
		} catch (Exception e) {
			msg = "Erro ao cadastrar cotacao.";
		}
		return msg;
	}

}
