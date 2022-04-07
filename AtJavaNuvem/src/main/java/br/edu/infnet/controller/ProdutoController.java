package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.model.Produto;
import br.edu.infnet.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/all")
    public List<Produto> list(){
        return produtoService.listAll();
    }

    @PostMapping
    public void incluir(@RequestBody Produto produto){
        produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public void atualizarPorId(@PathVariable int id, @RequestBody Produto produto){
        produtoService.atualizar(id, produto);
    }

    @GetMapping("/{id}")
    public void encontraPorId(@PathVariable int id){
        produtoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deletaPorId(@PathVariable int id){
        produtoService.deleteById(id);
    }

}
