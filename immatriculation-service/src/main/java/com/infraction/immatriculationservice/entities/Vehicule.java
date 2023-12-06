package com.infraction.immatriculationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String marque;
    private double puissance_fiscale; // Utiliser la convention camelCase pour le nom du champ
    private String modele;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id") // Nom de la colonne qui représente la clé étrangère
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Proprietaire proprietaire;

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", marque='" + marque + '\'' +
                ", puissanceFiscale=" + puissance_fiscale +
                ", modele='" + modele + '\'' +
                '}';
    }
}