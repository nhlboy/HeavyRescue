package com.example.demo.controller;

import com.example.demo.module.Driver;
import com.example.demo.repository.DriverRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/drivers")

public class DriversController {
    private DriverRepository driverRepository;

    public DriversController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping
    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }
}
