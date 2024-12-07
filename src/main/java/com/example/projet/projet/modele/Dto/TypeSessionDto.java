package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement
public class TypeSessionDto {
    private long idTypeSession;
    private String nomTypeSession;
    private String descriptionTypeSession;

    public TypeSessionDto() {

    }

    public TypeSessionDto(long idTypeSession, String nomTypeSession, String descriptionTypeSession) {
        this.idTypeSession = idTypeSession;
        this.nomTypeSession = nomTypeSession;
        this.descriptionTypeSession = descriptionTypeSession;
    }

    @XmlElement
    public long getIdTypeSession() {
        return idTypeSession;
    }

    public void setIdTypeSession(long idTypeSession) {
        this.idTypeSession = idTypeSession;
    }

    @XmlElement
    public String getNomTypeSession() {
        return nomTypeSession;
    }

    public void setNomTypeSession(String nomTypeSession) {
        this.nomTypeSession = nomTypeSession;
    }

    @XmlElement
    public String getDescriptionTypeSession() {
        return descriptionTypeSession;
    }

    public void setDescriptionTypeSession(String descriptionTypeSession) {
        this.descriptionTypeSession = descriptionTypeSession;
    }

}
