package com.infraction.radarsservice;

import com.infraction.radarsservice.entities.Radar;
import com.infraction.radarsservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RadarsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RadarsServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(RadarRepository radarRepository) {
        return args -> {
            radarRepository.saveAll(
                    List.of(
                            Radar.builder().vitesse_Maximale(50).latitude(48.8566).longitude(2.3522).build(),
                            Radar.builder().vitesse_Maximale(60).latitude(40.7128).longitude(-74.0060).build(),
                            Radar.builder().vitesse_Maximale(40).latitude(34.0522).longitude(-118.2437).build()
                    )
            );

            radarRepository.findAll().forEach(radar -> {
                System.out.println(radar);
            });
        };
    }
}
