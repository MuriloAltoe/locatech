package com.locatech.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.locatech.locatech.entities.Pessoa;
import com.locatech.locatech.repositories.PessoaRepository;

@Service
public class PessoaService {
        private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAllPessoas(int page, int size){
        int offset = (page - 1) * size;

        return this.pessoaRepository.findAll(size, offset);
    }

    public Optional<Pessoa> findByPessoaId(Long id){
        return this.pessoaRepository.findById(id);
    }

    public void savePessoa(Pessoa pessoa) {
        var save = this.pessoaRepository.save(pessoa);

        Assert.state(save == 1, "Erro ao salvar pessoa." + pessoa.getNome());
    }

    public void updatePessoa(Pessoa pessoa, Long id) {
        var update = this.pessoaRepository.update(pessoa, id);

        if (update == 0) {
            throw new RuntimeException("Pessoa não encontrado");
        }
    }

    public void deletePessoa(Long id){
        var delete = this.pessoaRepository.delete(id);

        if (delete == 0) {
            throw new RuntimeException("Pessoa não encontrado");
        }
    }
}
