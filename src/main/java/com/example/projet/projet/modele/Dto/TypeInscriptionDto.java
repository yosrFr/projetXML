package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

@XmlRootElement
public class TypeInscriptionDto {
    @Size(min = 10, max = 200)
    private String descriptionTypeInscription;
    @NotNull
    private long idTypeInscription;
    @NotNull
    private String nomTypeInscription;

    public TypeInscriptionDto() {

    }

    public TypeInscriptionDto(String descriptionTypeInscription, String nomTypeInscription, long idTypeInscription) {
        this.descriptionTypeInscription = descriptionTypeInscription;
        this.nomTypeInscription = nomTypeInscription;
        this.idTypeInscription = idTypeInscription;
    }

    @XmlElement (name = "DescriptionTypeInscri")
    public String getDescriptionTypeInscription() {
        return descriptionTypeInscription;
    }

    public void setDescriptionTypeInscription(String descriptionTypeInscription) {
        this.descriptionTypeInscription = descriptionTypeInscription;
    }

    @XmlElement (name = "IdTypeInscri")
    public long getIdTypeInscription() {
        return idTypeInscription;
    }

    public void setIdTypeInscription(long idTypeInscription) {
        this.idTypeInscription = idTypeInscription;
    }

    @XmlElement (name = "NomTypeInscri")
    public String getNomTypeInscription() {
        return nomTypeInscription;
    }

    public void setNomTypeInscription(String nomTypeInscription) {
        this.nomTypeInscription = nomTypeInscription;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TypeInscriptionDto that)) return false;
        return idTypeInscription == that.idTypeInscription && Objects.equals(descriptionTypeInscription, that.descriptionTypeInscription) && Objects.equals(nomTypeInscription, that.nomTypeInscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptionTypeInscription, idTypeInscription, nomTypeInscription);
    }
}
