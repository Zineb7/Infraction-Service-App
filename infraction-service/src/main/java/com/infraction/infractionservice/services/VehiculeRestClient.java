package com.infraction.infractionservice.services;

import com.infraction.infractionservice.model.Vehicule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="IMMATRICULATION-SERVICE" )
public interface VehiculeRestClient {
    @GetMapping(path = "vehicules/{id}")
    public  Vehicule findVehiculeByID(@PathVariable Long id);

}
