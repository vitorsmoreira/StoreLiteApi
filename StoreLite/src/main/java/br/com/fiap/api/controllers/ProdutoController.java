package br.com.fiap.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.exceptions.RestNotFoundException;
import br.com.fiap.api.models.Produto;
import br.com.fiap.api.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    Logger log = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/api/produto")
    public List<Produto> index(){
        return repository.findAll();
    
    }
    
    @PostMapping("/api/produto")
    public ResponseEntity<Object> create(@RequestBody @Valid Produto produto){
        log.info("Cadastrando produto" + produto);
        repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }


    @GetMapping("{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id) {
        log.info("Detalhando produto" + id);
        var produto = repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("produto não encontrado"));

        return ResponseEntity.ok(produto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Produto> destroy(@PathVariable Long id) {
        log.info("Apagando produto" + id);
        var produto = repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Erro ao apagar, produto não encontrado"));

        repository.delete(produto);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody @Valid Produto produto){
        log.info("Atualizando produto" + id);
        repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Erro ao atualizar, produto não encontrado"));

        produto.setId(id);
        repository.save(produto);

        return ResponseEntity.ok(produto);
        
    }

   
}