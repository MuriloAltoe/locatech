package com.locatech.locatech.swagger;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.locatech.locatech.dtos.AluguelRequestDTO;
import com.locatech.locatech.entities.Aluguel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Aluguel", description = "CRUD para gerenciar aluguéis")
public interface AluguelSwaggerOperation {

    @Operation(summary = "Listar todos os aluguéis", description = "Retorna uma lista de aluguéis paginada")
    public ResponseEntity<List<Aluguel>> findAllalugueis(
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    @Operation(summary = "Buscar aluguel por ID", description = "Retorna um aluguel pelo ID")
    public ResponseEntity<Optional<Aluguel>> findAluguelById(
            @PathVariable("id") Long id);

    @Operation(summary = "Salvar aluguel", description = "Cria um novo aluguel")
    public ResponseEntity<Void> saveAluguel(
            @Valid @RequestBody AluguelRequestDTO Aluguel);

    @Operation(summary = "Atualizar aluguel", description = "Atualiza um aluguel existente")
    public ResponseEntity<Void> updateAluguel(
            @PathVariable("id") Long id,
            @RequestBody Aluguel Aluguel);

    @Operation(summary = "Deletar aluguel", description = "Remove um aluguel pelo ID")
    public ResponseEntity<Void> deleteAluguel(
            @PathVariable("id") Long id);

}
