package com.aulaspring2.repository;

import com.aulaspring2.model.DataVenda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataVendaRepository extends CrudRepository<DataVenda, Long> {
}
