package com.locatech.locatech.swagger;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.locatech.locatech.entities.Veiculo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Veículo", description = "CRUD para gerenciar veículos")
public interface VeiculoSwaggerOperation {

    @Operation(summary = "Listar todos os veículos", description = "Retorna uma lista de veículos paginada")
    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    @Operation(summary = "Buscar veículo por ID", description = "Retorna um veículo pelo ID")
    public ResponseEntity<Optional<Veiculo>> findVeiculoById(
            @PathVariable("id") Long id);

    @Operation(summary = "Salvar veículo", description = "Cria um novo veículo")
    public ResponseEntity<Veiculo> saveVeiculo(
            @RequestBody Veiculo veiculo);

    @Operation(summary = "Atualizar veículo", description = "Atualiza um veículo existente")
    public ResponseEntity<Void> updateVeiculo(
            @PathVariable("id") Long id,
            @RequestBody Veiculo veiculo);

    @Operation(summary = "Deletar veículo", description = "Remove um veículo pelo ID")
    public ResponseEntity<Void> deleteVeiculo(
            @PathVariable("id") Long id);
    
}
