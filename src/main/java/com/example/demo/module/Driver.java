package com.example.demo.module;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity

public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int cdl;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToMany
    @JoinTable(name = "drivers_regions",
            joinColumns = { @JoinColumn(name = "driver_id") },
            inverseJoinColumns = { @JoinColumn(name = "regions_id") })

    private Set<Regions> regions = new HashSet<Regions>();

    public Set<Regions> addRegionsSet(Regions region) {
        regions.add(region);
        return regions;
    }

    public Set<Regions> removeRegionsSet(Regions region) {
        regions.remove(region);
        return regions;
    }
}
