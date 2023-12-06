package com.infraction.infractionservice;

import com.infraction.infractionservice.entities.Infraction;
import com.infraction.infractionservice.model.Vehicule;
import com.infraction.infractionservice.repositories.InfractionRepository;
import com.infraction.infractionservice.services.VehiculeRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
@EnableFeignClients
@SpringBootApplication
public class InfractionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfractionServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InfractionRepository infractionRepository, VehiculeRestClient vehiculeRestClient) {
        return args -> {
            Long vehiculeId=1L;
            Vehicule vehicule=vehiculeRestClient.findVehiculeByID(vehiculeId);
            if(vehicule==null) throw new RuntimeException("Vehicule not found");
            Infraction infraction=new Infraction();
            infraction.setDate(new Date());
            infraction.setVehiculeId(vehiculeId);
            infractionRepository.save(infraction);


        };
    }
}
