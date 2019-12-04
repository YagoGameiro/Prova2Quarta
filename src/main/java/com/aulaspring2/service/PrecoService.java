package com.aulaspring2.service;

import com.aulaspring2.model.Preco;
import com.aulaspring2.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository repository;

    public Iterable<Preco> findAllPreco() {
        return repository.findAll();
    }
    public Preco inserirPreco(Preco local) {
        return repository.save(local);
    }

    public Preco findOnePreco(Long id) {
        return repository.findOne(id);
    }

    public void deletePreco(Long id) {
        repository.delete(id);
    }
}
