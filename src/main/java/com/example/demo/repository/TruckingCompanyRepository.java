package com.example.demo.repository;

import com.example.demo.module.TruckingCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckingCompanyRepository extends CrudRepository<TruckingCompany, Integer> {
}
