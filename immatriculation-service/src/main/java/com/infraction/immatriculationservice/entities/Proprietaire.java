package com.infraction.immatriculationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date date_naissance;
    private String email;
    private int tel;

    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL)
    private List<Vehicule> vehicules;

    @Override
    public String toString() {
        return "Proprietaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", date_naissance=" + date_naissance +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                '}';
    }
}