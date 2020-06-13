package com.example.demo.controller;

import com.example.demo.module.Driver;
import com.example.demo.module.Truck;
import com.example.demo.repository.DriverRepository;
import com.example.demo.repository.TruckRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/truck")

public class TruckController {
    private TruckRepository truckRepository;

    private DriverRepository driverRepository;


    public TruckController(TruckRepository truckRepository,DriverRepository driverRepository) {
        this.truckRepository = truckRepository;
        this.driverRepository = driverRepository;
    }

    @GetMapping
    public Iterable<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    @PostMapping
    public Truck createTruck(@RequestBody Truck truck) {
        return truckRepository.save(truck);
    }

    @GetMapping("/adddrivertotruck/{id1}/{id2}")
    public Truck addDriverToTruck(@PathVariable int id1, @PathVariable int id2) {
        Truck truck = truckRepository.findById(id1).get();
        Driver driver = driverRepository.findById(id2).get();
    truck.addToDriverList(driver);
    return truckRepository.save(truck);
    }



}
