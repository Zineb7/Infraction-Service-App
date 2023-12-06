package com.infraction.infractionservice.entities;


import com.infraction.infractionservice.model.Vehicule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Infraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Long radarId;
    private Long vehiculeId;
    //dans la classe mais pas rep dans bd
    @Transient
    private Vehicule vehicule;
    private double vitesseVehicule;
    private double vitesseMaxRadar;
    private double montantInfraction;

    /*
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;*/

    @Override
    public String toString() {
        return "Infraction{" +
                "id=" + id +
                ", date=" + date +
                ", radarId=" + radarId +
                ", vitesseVehicule=" + vitesseVehicule +
                ", vitesseMaxRadar=" + vitesseMaxRadar +
                ", montantInfraction=" + montantInfraction +
                '}';
    }
}
