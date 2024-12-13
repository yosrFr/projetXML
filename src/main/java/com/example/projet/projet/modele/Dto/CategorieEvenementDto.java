package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement
public class CategorieEvenementDto {
    @NotNull
    private long idCategorieEvenement;
    @NotNull
    private String nomCategorieEvenement;
    @Size(min = 10, max = 200)
    private String descriptionCategorieEvenement;

    public CategorieEvenementDto() {

    }

    public CategorieEvenementDto(long idCategorieEvenement, String nomCategorieEvenement, String descriptionCategorieEvenement) {
        this.idCategorieEvenement = idCategorieEvenement;
        this.nomCategorieEvenement = nomCategorieEvenement;
        this.descriptionCategorieEvenement = descriptionCategorieEvenement;
    }

    @XmlElement
    public long getIdCategorieEvenement() {
        return idCategorieEvenement;
    }

    public void setIdCategorieEvenement(long idCategorieEvenement) {
        this.idCategorieEvenement = idCategorieEvenement;
    }

    @XmlElement
    public String getNomCategorieEvenement() {
        return nomCategorieEvenement;
    }

    public void setNomCategorieEvenement(String nomCategorieEvenement) {
        this.nomCategorieEvenement = nomCategorieEvenement;
    }

    @XmlElement
    public String getDescriptionCategorieEvenement() {
        return descriptionCategorieEvenement;
    }

    public void setDescriptionCategorieEvenement(String descriptionCategorieEvenement) {
        this.descriptionCategorieEvenement = descriptionCategorieEvenement;
    }

}
