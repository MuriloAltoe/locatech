package com.locatech.locatech.repositories;

import java.util.List;
import java.util.Optional;

import com.locatech.locatech.entities.Aluguel;

public interface AluguelRepository {

    Optional<Aluguel> findById(Long id);

    List<Aluguel> findAll(int size, int offset);

    Integer save(Aluguel aluguel);

    Integer update(Aluguel aluguel, Long id);

    Integer delete(Long id);
}
