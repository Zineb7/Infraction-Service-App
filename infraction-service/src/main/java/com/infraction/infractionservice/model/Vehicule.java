package com.infraction.infractionservice.model;

import lombok.Data;

@Data
public class Vehicule {
    private Long id;
    private String matricule;
    private String marque;
    private double puissance_fiscale; // Utiliser la convention camelCase pour le nom du champ
    private String modele;
}
