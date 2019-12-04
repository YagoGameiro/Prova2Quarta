package com.aulaspring2.repository;

import com.aulaspring2.model.Preco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoRepository extends CrudRepository<Preco, Long> {
}
