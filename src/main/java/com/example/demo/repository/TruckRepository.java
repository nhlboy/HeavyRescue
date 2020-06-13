package com.example.demo.repository;

import com.example.demo.module.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends CrudRepository<Truck, Integer> {
}
