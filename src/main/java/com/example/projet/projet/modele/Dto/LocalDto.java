package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@XmlRootElement(name = "Locaux", namespace = "http://www.example.com/Locaux")
public class LocalDto {
    @NotNull
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

    @XmlElement (name = "AdresseLocal")
    public String getAdresseLocal() {
        return adresseLocal;
    }

    public void setAdresseLocal(String adresseLocal) {
        this.adresseLocal = adresseLocal;
    }

    @XmlElement (name = "CapaciteLocal")
    public int getCapaciteLocal() {
        return capaciteLocal;
    }

    public void setCapaciteLocal(int capaciteLocal) {
        this.capaciteLocal = capaciteLocal;
    }

    @XmlElement (name = "IdLocal")
    public long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(long idLocal) {
        this.idLocal = idLocal;
    }

    @XmlElement (name = "NomLocal")
    public String getNomLocal() {
        return nomLocal;
    }

    public void setNomLocal(String nomLocal) {
        this.nomLocal = nomLocal;
    }

    @XmlElement (name = "NumTelLocal")
    public String getNumTelLocal() {
        return numTelLocal;
    }

    public void setNumTelLocal(String numTelLocal) {
        this.numTelLocal = numTelLocal;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LocalDto localDto)) return false;
        return capaciteLocal == localDto.capaciteLocal && idLocal == localDto.idLocal && Objects.equals(adresseLocal, localDto.adresseLocal) && Objects.equals(nomLocal, localDto.nomLocal) && Objects.equals(numTelLocal, localDto.numTelLocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresseLocal, capaciteLocal, idLocal, nomLocal, numTelLocal);
    }
}
