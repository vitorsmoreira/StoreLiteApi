package br.com.fiap.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.exceptions.RestNotFoundException;
import br.com.fiap.api.models.Mercado;
import br.com.fiap.api.repositories.MercadoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/api/mercado")
public class MercadoController {

    Logger log = LoggerFactory.getLogger(MercadoController.class);

    @Autowired
    MercadoRepository repository;

    @GetMapping
    public Page<Mercado> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable){
        if (busca == null) return repository.findAll(pageable);
        return repository.findByNomeContaining(busca, pageable);
    }




    

    @PostMapping("/api/mercado")
    public ResponseEntity<Object> create(@RequestBody @Valid Mercado mercado){
        log.info("Cadastrando mercado" + mercado);
        repository.save(mercado);
        return ResponseEntity.status(HttpStatus.CREATED).body(mercado);
    }


    @GetMapping("{id}")
    public ResponseEntity<Mercado> show(@PathVariable Long id) {
        log.info("Detalhando mercado" + id);
        var mercado = repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("mercado não encontrado"));

        return ResponseEntity.ok(mercado);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<Mercado> destroy(@PathVariable Long id) {
        log.info("Apagando mercado" + id);
        var mercado = repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Erro ao apagar, mercado não encontrado"));

        repository.delete(mercado);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Mercado> update(@PathVariable Long id, @RequestBody @Valid Mercado mercado){
        log.info("Atualizando mercado" + id);
        repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Erro ao atualizar, mercado não encontrado"));

        mercado.setId(id);
        repository.save(mercado);

        return ResponseEntity.ok(mercado);
        
    }
}