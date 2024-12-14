package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.Objects;

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
    private String dateAchatMateriel;

    public MaterielDto() {

    }

    public MaterielDto(long idMateriel, String nomMateriel, String marqueMateriel, String modeleMateriel, String dateAchatMateriel) {
        this.idMateriel = idMateriel;
        this.nomMateriel = nomMateriel;
        this.marqueMateriel = marqueMateriel;
        this.modeleMateriel = modeleMateriel;
        this.dateAchatMateriel = dateAchatMateriel;

    }

    @XmlElement (name = "VIdMat")
    public long getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(long idMateriel) {
        this.idMateriel = idMateriel;
    }

    @XmlElement (name = "NomMat")
    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    @XmlElement (name = "MarqueMat")
    public String getMarqueMateriel() {
        return marqueMateriel;
    }

    public void setMarqueMateriel(String marqueMateriel) {
        this.marqueMateriel = marqueMateriel;
    }

    @XmlElement (name = "ModeleMat")
    public String getModeleMateriel() {
        return modeleMateriel;
    }

    public void setModeleMateriel(String modeleMateriel) {
        this.modeleMateriel = modeleMateriel;
    }

    @XmlElement (name = "DateAchatMat")
    public String getDateAchatMateriel() {
        return dateAchatMateriel;
    }

    public void setDateAchatMateriel(String dateAchatMateriel) {
        this.dateAchatMateriel = dateAchatMateriel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MaterielDto that)) return false;
        return idMateriel == that.idMateriel && Objects.equals(nomMateriel, that.nomMateriel) && Objects.equals(marqueMateriel, that.marqueMateriel) && Objects.equals(modeleMateriel, that.modeleMateriel) && Objects.equals(dateAchatMateriel, that.dateAchatMateriel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMateriel, nomMateriel, marqueMateriel, modeleMateriel, dateAchatMateriel);
    }
}
