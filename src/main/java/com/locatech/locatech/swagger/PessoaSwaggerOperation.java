package com.locatech.locatech.swagger;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.locatech.locatech.entities.Pessoa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pessoa", description = "CRUD para gerenciar pessoas")
public interface PessoaSwaggerOperation {

    @Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista de pessoas paginada")
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    @Operation(summary = "Buscar pessoa por ID", description = "Retorna uma pessoa pelo ID")
    public ResponseEntity<Optional<Pessoa>> findPessoaById(
            @PathVariable("id") Long id);

    @Operation(summary = "Salvar pessoa", description = "Cria uma nova pessoa")
    public ResponseEntity<Pessoa> savePessoa(
            @RequestBody Pessoa pessoa);

    @Operation(summary = "Atualizar pessoa", description = "Atualiza uma pessoa existente")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable("id") Long id,
            @RequestBody Pessoa pessoa);

    @Operation(summary = "Deletar pessoa", description = "Remove uma pessoa pelo ID")
    public ResponseEntity<Void> deletePessoa(
            @PathVariable("id") Long id);
}
