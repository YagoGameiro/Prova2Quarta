package com.aulaspring2.service;

import com.aulaspring2.model.Telefone;
import com.aulaspring2.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    public Iterable<Telefone> findAllTelefone() {
        return repository.findAll();
    }
    public Telefone inserirTelefone(Telefone telefone) {
        return repository.save(telefone);
    }

    public Telefone findOneTelefone(Long id) {
        return repository.findOne(id);
    }

    public void deleteTelefone(Long id) {
        repository.delete(id);
    }
}
