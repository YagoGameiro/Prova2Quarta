package com.aulaspring2.service;

import com.aulaspring2.model.Funcionario;
import com.aulaspring2.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public Iterable<Funcionario> findAll() {
        return repository.findAll();
    }
    public Funcionario inserir(Funcionario local) {
        return repository.save(local);
    }

    public Funcionario findOne(Long id) {
        return repository.findOne(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
