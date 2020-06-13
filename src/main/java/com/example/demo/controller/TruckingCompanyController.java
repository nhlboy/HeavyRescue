package com.example.demo.controller;

import com.example.demo.module.Truck;
import com.example.demo.module.TruckingCompany;
import com.example.demo.repository.TruckRepository;
import com.example.demo.repository.TruckingCompanyRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/truckingcompany")

public class TruckingCompanyController {
    private TruckingCompanyRepository truckingCompanyRepository;

    private TruckRepository truckRepository;

    public TruckingCompanyController(TruckingCompanyRepository truckingCompanyRepository,
                                     TruckRepository truckRepository) {
        this.truckingCompanyRepository = truckingCompanyRepository;
        this.truckRepository = truckRepository;

    }


    @GetMapping
    public Iterable<TruckingCompany> getAllTruckingCompanies() {
        return truckingCompanyRepository.findAll();
    }


    @GetMapping("/{id1}/{id2}")
    public TruckingCompany addTruckToTruckCompany(@PathVariable int id1, @PathVariable int id2) {
        TruckingCompany truckingCompany = truckingCompanyRepository.findById(id1).get();
        Truck truck = truckRepository.findById(id2).get();
        truckingCompany.setTruck(truck);
        return truckingCompanyRepository.save(truckingCompany);
    }

    @PostMapping
    public TruckingCompany createTruckingCompany(@RequestBody TruckingCompany truckingCompany) {
        return truckingCompanyRepository.save(truckingCompany);
    }
}
