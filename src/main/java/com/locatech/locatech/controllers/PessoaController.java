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
import com.locatech.locatech.swagger.PessoaSwaggerOperation;

@RestController
@RequestMapping("/pessoas")
public class PessoaController implements PessoaSwaggerOperation {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService PessoaService) {
        this.pessoaService = PessoaService;
    }

    @GetMapping // /Pessoas - GET
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("/Pessoas");

        var pessoa = this.pessoaService.findAllPessoas(page, size);

        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}") // /Pessoas/1 - GET
    public ResponseEntity<Optional<Pessoa>> findPessoaById(
            @PathVariable("id") Long id) {
        logger.info("/Pessoas/" + id);

        var pessoa = this.pessoaService.findByPessoaId(id);

        return ResponseEntity.ok(pessoa);
    }

    @PostMapping()
    public ResponseEntity<Pessoa> savePessoa(
            @RequestBody Pessoa pessoa) {
        logger.info("POST -> /Pessoa");
        this.pessoaService.savePessoa(pessoa);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable("id") Long id,
            @RequestBody Pessoa pessoa) {
        logger.info("PUT -> /Pessoas/" + id);
        this.pessoaService.updatePessoa(pessoa, id);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(
        @PathVariable("id") Long id
    ) {
        logger.info("DELETE -> /Pessoas/" +id);
        this.pessoaService.deletePessoa(id);

        return ResponseEntity.ok().build();
    }
}


