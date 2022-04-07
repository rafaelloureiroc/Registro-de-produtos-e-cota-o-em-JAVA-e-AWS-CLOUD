package br.edu.infnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.Produto;
import br.edu.infnet.model.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> listAll() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public String atualizar(int id, Produto produto){
        String msg = "";
        Produto produtoAtualizado = produtoRepository.findById(id).get();

        if(produtoAtualizado != null){
            produtoAtualizado.setId(produto.getId());
            produtoAtualizado.setNome(produto.getNome());
            produtoAtualizado.setCotacoes(produto.getCotacoes());        

            produtoRepository.save(produtoAtualizado);
            msg = "Produto cadastrado.";
            return msg;
        }else{
            msg = "Erro ao cadastrar produto.";
        }

        return msg;
    }

    public Optional<Produto> getById(int id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            return produto;
        }
        return null;
    }

    public void deleteById(int id){
        produtoRepository.deleteById(id);
    }

}
