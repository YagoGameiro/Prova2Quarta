package com.aulaspring2.service;

import com.aulaspring2.model.DataVenda;
import com.aulaspring2.repository.DataVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataVendaService {

    @Autowired
    private DataVendaRepository repository;

    public Iterable<DataVenda> findAllDataVenda() {
        return repository.findAll();
    }
    public DataVenda inserirDataVenda(DataVenda local) {
        return repository.save(local);
    }

    public DataVenda findOneDataVenda(Long id) {
        return repository.findOne(id);
    }

    public void deleteDataVenda(Long id) {
        repository.delete(id);
    }
}
