package com.example.demo.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class TruckingCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameOnTheDoor;

    @OneToOne(mappedBy = "truckingCompany")
    @JsonIgnore
//    @JoinColumn(name ="truck_id")
    private Truck truck;
}
