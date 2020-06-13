package com.example.demo.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String unitMake;

    @OneToOne
    @JoinColumn(name ="truck_company_id")
    private TruckingCompany truckingCompany;

    @OneToMany(mappedBy = "truck")

    private List<Driver> drivers = new ArrayList<>();

    public List<Driver> addToDriverList (Driver driver) {
        this.drivers.add(driver);
        return drivers;
    }
}
