package com.infraction.infractionservice.web;

import com.infraction.infractionservice.entities.Infraction;
import com.infraction.infractionservice.repositories.InfractionRepository;
import com.infraction.infractionservice.services.VehiculeRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfractionRestController {
    @Autowired
    private InfractionRepository infractionRepository;
    @Autowired
    private VehiculeRestClient vehiculeRestClient;
    /*public InfractionRestController(InfractionRepository infractionRepository, VehiculeRestClient vehiculeRestClient) {
        this.infractionRepository = infractionRepository;
        this.vehiculeRestClient = vehiculeRestClient;
    }*/
    //consulter infraction
    @GetMapping("/fullInfraction/{id}")
    public Infraction infraction(@PathVariable Long id) {
        Infraction infraction = infractionRepository.findById(id).orElse(null);
        infraction.setVehicule(vehiculeRestClient.findVehiculeByID(infraction.getVehiculeId()));
        return infraction;
    }


}
