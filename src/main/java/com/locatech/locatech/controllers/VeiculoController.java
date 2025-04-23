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

import com.locatech.locatech.entities.Veiculo;
import com.locatech.locatech.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping // /veiculos - GET
    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("/veiculos");

        var veiculo = this.veiculoService.findAllVeiculos(page, size);

        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/{id}") // /veiculos/1 - GET
    public ResponseEntity<Optional<Veiculo>> findVeiculoById(
            @PathVariable("id") Long id) {
        logger.info("/veiculos/" + id);

        var veiculo = this.veiculoService.findByVeiculoId(id);

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping()
    public ResponseEntity<Veiculo> saveVeiculo(
            @RequestBody Veiculo veiculo) {
        logger.info("POST -> /veiculo");
        this.veiculoService.saveVeiculo(veiculo);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(
            @PathVariable("id") Long id,
            @RequestBody Veiculo veiculo) {
        logger.info("PUT -> /veiculos/" + id);
        this.veiculoService.updateVeiculo(veiculo, id);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(
            @PathVariable("id") Long id) {
        logger.info("DELETE -> /veiculos/" + id);
        this.veiculoService.deleteVeiculo(id);

        return ResponseEntity.ok().build();
    }
}
