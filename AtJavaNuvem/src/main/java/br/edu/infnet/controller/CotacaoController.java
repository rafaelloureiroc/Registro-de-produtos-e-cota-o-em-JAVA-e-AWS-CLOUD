package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.model.Cotacao;
import br.edu.infnet.model.Fornecedor;
import br.edu.infnet.service.CotacaoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cotacoes")
public class CotacaoController {

	@Autowired
	CotacaoService cotacaoService;

	@GetMapping("/all")
	public List<Cotacao> list() {
		return cotacaoService.listAll();
	}

	@PostMapping
	public String incluir(@RequestBody Cotacao cotacao) throws Exception {
		String cotacaoSalvo = cotacaoService.save(cotacao);
		return cotacaoSalvo;
	}

	@GetMapping("/{id}")
	public String encontraPorId(@PathVariable int id) {
		Optional<Cotacao> cotacao = cotacaoService.getById(id);
		return cotacao.toString();
	}

	@PutMapping("/{id}")
	public String atualizarPorId(@PathVariable int id, @RequestBody Cotacao cotacao) {
		String cotacaoAtualizado = cotacaoService.atualizar(id, cotacao);
		return cotacaoAtualizado;

	}

	@DeleteMapping("/{id}")
	public String deletaPorId(@PathVariable int id) throws Exception {
		String cotacaoExcluido = cotacaoService.deleteById(id);
		return cotacaoExcluido;
	}
}
