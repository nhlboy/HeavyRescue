package com.example.demo.controller;

import com.example.demo.module.Driver;
import com.example.demo.module.Regions;
import com.example.demo.repository.DriverRepository;
import com.example.demo.repository.RegionsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regions")

public class RegionsController {
    private RegionsRepository regionsRepository;

    private DriverRepository driverRepository;

    public RegionsController(RegionsRepository regionsRepository, DriverRepository driverRepository) {
        this.regionsRepository = regionsRepository;
        this.driverRepository = driverRepository;
    }

    @GetMapping
    public Iterable<Regions> getAllRegions() {
        return regionsRepository.findAll();

    }

    @PostMapping
    public Regions createRegion (@RequestBody Regions regions){
        return regionsRepository.save(regions);
    }

    @GetMapping("/{idRegion}/{idDriver}")
    public Regions addDriverToRegion (@PathVariable int idRegion, @PathVariable int idDriver) {
        Regions region = regionsRepository.findById(idRegion).get();
        Driver driver = driverRepository.findById(idDriver).get();
        region.addDriverSet(driver);
        return regionsRepository.save(region);
    }


}
