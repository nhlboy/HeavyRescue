package com.example.demo.repository;

import ch.qos.logback.core.joran.action.IADataForComplexProperty;
import com.example.demo.module.Regions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RegionsRepository extends CrudRepository<Regions, Integer> {

}
