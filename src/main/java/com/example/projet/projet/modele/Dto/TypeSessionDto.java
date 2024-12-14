package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

@XmlRootElement
public class TypeSessionDto {
    @NotNull
    private long idTypeSession;
    @NotNull
    private String nomTypeSession;
    @Size(min = 10, max = 200)
    private String descriptionTypeSession;

    public TypeSessionDto() {

    }

    public TypeSessionDto(long idTypeSession, String nomTypeSession, String descriptionTypeSession) {
        this.idTypeSession = idTypeSession;
        this.nomTypeSession = nomTypeSession;
        this.descriptionTypeSession = descriptionTypeSession;
    }

    @XmlElement (name = "IdTypeSession")
    public long getIdTypeSession() {
        return idTypeSession;
    }

    public void setIdTypeSession(long idTypeSession) {
        this.idTypeSession = idTypeSession;
    }

    @XmlElement (name = "NomTypeSession")
    public String getNomTypeSession() {
        return nomTypeSession;
    }

    public void setNomTypeSession(String nomTypeSession) {
        this.nomTypeSession = nomTypeSession;
    }

    @XmlElement (name = "DescriptionTypeSession")
    public String getDescriptionTypeSession() {
        return descriptionTypeSession;
    }

    public void setDescriptionTypeSession(String descriptionTypeSession) {
        this.descriptionTypeSession = descriptionTypeSession;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TypeSessionDto that)) return false;
        return idTypeSession == that.idTypeSession && Objects.equals(nomTypeSession, that.nomTypeSession) && Objects.equals(descriptionTypeSession, that.descriptionTypeSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeSession, nomTypeSession, descriptionTypeSession);
    }
}
