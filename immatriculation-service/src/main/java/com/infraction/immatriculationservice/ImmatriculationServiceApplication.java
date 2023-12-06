package com.infraction.immatriculationservice;

import com.infraction.immatriculationservice.entities.Proprietaire;
import com.infraction.immatriculationservice.entities.Vehicule;
import com.infraction.immatriculationservice.repository.ProprietaireRepository;
import com.infraction.immatriculationservice.repository.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ImmatriculationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmatriculationServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            VehiculeRepository vehiculeRepository,
            ProprietaireRepository proprietaireRepository,
            RepositoryRestConfiguration repositoryRestConfiguration
    ) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Vehicule.class);
            repositoryRestConfiguration.exposeIdsFor(Proprietaire.class);

            // Creation de propr
            Proprietaire proprietaire1 = new Proprietaire();
            proprietaire1.setNom("Zey Chafiki");
            proprietaire1.setDate_naissance(new Date());
            proprietaire1.setEmail("zeyneb@example.com");
            proprietaireRepository.save(proprietaire1);

            // Creation de vehicules des proprietaires
            vehiculeRepository.saveAll(
                    List.of(
                            Vehicule.builder().matricule("matricule1").marque("mercedes").puissance_fiscale(700).modele("R70056O").proprietaire(proprietaire1).build(),
                            Vehicule.builder().matricule("matricule2").marque("dacia").puissance_fiscale(800).modele("R700588").proprietaire(proprietaire1).build(),
                            Vehicule.builder().matricule("matricule3").marque("renault").puissance_fiscale(300).modele("P50056O").proprietaire(proprietaire1).build()
                    )
            );

            vehiculeRepository.findAll().forEach(vehicule -> {
                System.out.println(vehicule);
            });

            proprietaireRepository.findAll().forEach(proprietaire -> {
                System.out.println(proprietaire);
            });
        };
    }
}