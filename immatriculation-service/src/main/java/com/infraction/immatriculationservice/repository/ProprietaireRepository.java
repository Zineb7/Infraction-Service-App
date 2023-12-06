package com.infraction.immatriculationservice.repository;

import com.infraction.immatriculationservice.entities.Proprietaire;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ProprietaireRepository extends JpaRepository<Proprietaire,Long> {
}
