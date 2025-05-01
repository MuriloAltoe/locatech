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

import com.locatech.locatech.dtos.AluguelRequestDTO;
import com.locatech.locatech.entities.Aluguel;
import com.locatech.locatech.services.AluguelService;

import com.locatech.locatech.swagger.AluguelSwaggerOperation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alugueis")
public class AluguelController implements AluguelSwaggerOperation {
    
    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService AluguelService) {
        this.aluguelService = AluguelService;
    }

    @GetMapping // /alugueis - GET
    public ResponseEntity<List<Aluguel>> findAllalugueis(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("/alugueis");

        var aluguel = this.aluguelService.findAllAlugueis(page, size);

        return ResponseEntity.ok(aluguel);
    }

    @GetMapping("/{id}") // /alugueis/1 - GET
    public ResponseEntity<Optional<Aluguel>> findAluguelById(
            @PathVariable("id") Long id) {
        logger.info("/alugueis/" + id);

        var aluguel = this.aluguelService.findByAluguelId(id);

        return ResponseEntity.ok(aluguel);
    }

    @PostMapping()
    public ResponseEntity<Void> saveAluguel(
            @Valid @RequestBody AluguelRequestDTO Aluguel
        ) {
        logger.info("POST -> /Aluguel");
        this.aluguelService.saveAluguel(Aluguel);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(
            @PathVariable("id") Long id,
            @RequestBody Aluguel Aluguel) {
        logger.info("PUT -> /alugueis/" + id);
        this.aluguelService.updateAluguel(Aluguel, id);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(
        @PathVariable("id") Long id
    ) {
        logger.info("DELETE -> /alugueis/" +id);
        this.aluguelService.deleteAluguel(id);

        return ResponseEntity.ok().build();
    }

}
