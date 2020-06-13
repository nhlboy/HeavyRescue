package com.example.demo.repository;

import com.example.demo.module.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {

}
