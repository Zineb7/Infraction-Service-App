package com.infraction.immatriculationservice.repository;

import com.infraction.immatriculationservice.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
