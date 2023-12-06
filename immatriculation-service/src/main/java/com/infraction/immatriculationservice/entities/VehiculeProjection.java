package com.infraction.immatriculationservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullVehicule",types = Vehicule.class)
public interface VehiculeProjection {
    public String getmatricule();
    public Long getid();
}
