package com.aulaspring2.service;

import com.aulaspring2.model.Cliente;
import com.aulaspring2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Iterable<Cliente> findAllCliente() {
        return repository.findAll();
    }
    public Cliente inserirCliente(Cliente local) {
        return repository.save(local);
    }

    public Cliente findOneCliente(Long id) {
        return repository.findOne(id);
    }

    public void deleteCliente(Long id) {
        repository.delete(id);
    }
}
