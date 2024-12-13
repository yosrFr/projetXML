package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlRootElement
public class MaterielDto {
    @NotNull
    private long idMateriel;
    @NotNull
    private String nomMateriel;
    @NotNull
    private String marqueMateriel;
    @NotNull
    private String modeleMateriel;
    @NotNull
    private Date dateAchatMateriel;

    public MaterielDto() {

    }

    public MaterielDto(long idMateriel, String nomMateriel, String marqueMateriel, String modeleMateriel, Date dateAchatMateriel) {
        this.idMateriel = idMateriel;
        this.nomMateriel = nomMateriel;
        this.marqueMateriel = marqueMateriel;
        this.modeleMateriel = modeleMateriel;
        this.dateAchatMateriel = dateAchatMateriel;

    }

    @XmlElement
    public long getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(long idMateriel) {
        this.idMateriel = idMateriel;
    }

    @XmlElement
    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    @XmlElement
    public String getMarqueMateriel() {
        return marqueMateriel;
    }

    public void setMarqueMateriel(String marqueMateriel) {
        this.marqueMateriel = marqueMateriel;
    }

    @XmlElement
    public String getModeleMateriel() {
        return modeleMateriel;
    }

    public void setModeleMateriel(String modeleMateriel) {
        this.modeleMateriel = modeleMateriel;
    }

    @XmlElement
    public Date getDateAchatMateriel() {
        return dateAchatMateriel;
    }

    public void setDateAchatMateriel(Date dateAchatMateriel) {
        this.dateAchatMateriel = dateAchatMateriel;
    }

}
