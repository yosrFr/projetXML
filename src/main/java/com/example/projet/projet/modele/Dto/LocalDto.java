package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;

@XmlRootElement
public class LocalDto {
    @Size(min = 4, max = 30)
    private String adresseLocal;
    @NotNull
    private int capaciteLocal;
    @NotNull
    private long idLocal;
    @NotNull
    private String nomLocal;
    @NotNull
    @Length(min = 12, max = 12)
    private String numTelLocal;

    public LocalDto() {

    }

    public LocalDto(String adresseLocal, int capaciteLocal, long idLocal, String nomLocal, String numTelLocal) {
        this.adresseLocal = adresseLocal;
        this.capaciteLocal = capaciteLocal;
        this.idLocal = idLocal;
        this.nomLocal = nomLocal;
        this.numTelLocal = numTelLocal;
    }

    @XmlElement
    public String getAdresseLocal() {
        return adresseLocal;
    }

    public void setAdresseLocal(String adresseLocal) {
        this.adresseLocal = adresseLocal;
    }

    @XmlElement
    public int getCapaciteLocal() {
        return capaciteLocal;
    }

    public void setCapaciteLocal(int capaciteLocal) {
        this.capaciteLocal = capaciteLocal;
    }

    @XmlElement
    public long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(long idLocal) {
        this.idLocal = idLocal;
    }

    @XmlElement
    public String getNomLocal() {
        return nomLocal;
    }

    public void setNomLocal(String nomLocal) {
        this.nomLocal = nomLocal;
    }

    @XmlElement
    public String getNumTelLocal() {
        return numTelLocal;
    }

    public void setNumTelLocal(String numTelLocal) {
        this.numTelLocal = numTelLocal;
    }

}
