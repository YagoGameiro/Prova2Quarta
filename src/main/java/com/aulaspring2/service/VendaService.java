package com.aulaspring2.service;

import com.aulaspring2.model.Venda;
import com.aulaspring2.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public Iterable<Venda> findAllVenda() {
        return repository.findAll();
    }
    public Venda inserirVenda(Venda local) {
        return repository.save(local);
    }

    public Venda findOneVenda(Long id) {
        return repository.findOne(id);
    }

    public void deleteVenda(Long id) {
        repository.delete(id);
    }
}
