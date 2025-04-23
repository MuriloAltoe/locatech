package com.locatech.locatech.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.locatech.locatech.entities.Pessoa;
import com.locatech.locatech.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService PessoaService;

    public PessoaController(PessoaService PessoaService) {
        this.PessoaService = PessoaService;
    }

    @GetMapping // /Pessoas - GET
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("/Pessoas");

        var Pessoa = this.PessoaService.findAllPessoas(page, size);

        return ResponseEntity.ok(Pessoa);
    }

    @GetMapping("/{id}") // /Pessoas/1 - GET
    public ResponseEntity<Optional<Pessoa>> findPessoaById(
            @PathVariable("id") Long id) {
        logger.info("/Pessoas/" + id);

        var Pessoa = this.PessoaService.findByPessoaId(id);

        return ResponseEntity.ok(Pessoa);
    }

    @PostMapping()
    public ResponseEntity<Pessoa> savePessoa(
            @RequestBody Pessoa Pessoa) {
        logger.info("POST -> /Pessoa");
        this.PessoaService.savePessoa(Pessoa);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable("id") Long id,
            @RequestBody Pessoa Pessoa) {
        logger.info("PUT -> /Pessoas/" + id);
        this.PessoaService.updatePessoa(Pessoa, id);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(
        @PathVariable("id") Long id
    ) {
        logger.info("DELETE -> /Pessoas/" +id);
        this.PessoaService.deletePessoa(id);

        return ResponseEntity.ok().build();
    }
}


