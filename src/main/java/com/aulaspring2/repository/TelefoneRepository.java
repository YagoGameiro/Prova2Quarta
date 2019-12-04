package com.aulaspring2.repository;

import com.aulaspring2.model.Telefone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Long> {
}
