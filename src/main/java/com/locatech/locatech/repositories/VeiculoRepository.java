package com.locatech.locatech.repositories;

import java.util.List;
import java.util.Optional;

import com.locatech.locatech.entities.Veiculo;

public interface VeiculoRepository {

    Optional<Veiculo> findById(Long id);

    List<Veiculo> findAll(int size, int offset);

    Integer save(Veiculo veiculo);

    Integer update(Veiculo veiculo, Long id);

    Integer delete(Long id);
}
