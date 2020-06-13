package com.example.demo.module;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Regions {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "drivers_regions",
            joinColumns = { @JoinColumn(name = "regions_id") },
            inverseJoinColumns = { @JoinColumn(name = "driver_id") })

    private Set<Driver> drivers = new HashSet<Driver>();

    public Set<Driver> addDriverSet(Driver driver) {
        drivers.add(driver);
        return drivers;
    }

    public Set<Driver> removeDriverSet(Driver driver) {
        drivers.remove(driver);
        return drivers;
    }


}
