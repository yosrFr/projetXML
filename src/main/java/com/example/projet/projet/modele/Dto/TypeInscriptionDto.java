package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

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

    @XmlElement
    public String getDescriptionTypeInscription() {
        return descriptionTypeInscription;
    }

    public void setDescriptionTypeInscription(String descriptionTypeInscription) {
        this.descriptionTypeInscription = descriptionTypeInscription;
    }

    @XmlElement
    public long getIdTypeInscription() {
        return idTypeInscription;
    }

    public void setIdTypeInscription(long idTypeInscription) {
        this.idTypeInscription = idTypeInscription;
    }

    @XmlElement
    public String getNomTypeInscription() {
        return nomTypeInscription;
    }

    public void setNomTypeInscription(String nomTypeInscription) {
        this.nomTypeInscription = nomTypeInscription;
    }

}
