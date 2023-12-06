package com.infraction.infractionservice.repositories;
import com.infraction.infractionservice.entities.Infraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface InfractionRepository extends JpaRepository<Infraction,Long> {
}

