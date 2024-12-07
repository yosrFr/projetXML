package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AffectationPersonnelDto {
    private long idAffectationPersonnel;
    private PersonnelDto personnel;
    private SessionDto session;

    public AffectationPersonnelDto() {

    }

    public AffectationPersonnelDto(long idAffectationPersonnel, PersonnelDto personnel, SessionDto session) {
        this.idAffectationPersonnel = idAffectationPersonnel;
        this.personnel = personnel;
        this.session = session;
    }

    @XmlElement
    public long getIdAffectationPersonnel() {
        return idAffectationPersonnel;
    }

    public void setIdAffectationPersonnel(long idAffectationPersonnel) {
        this.idAffectationPersonnel = idAffectationPersonnel;
    }

    @XmlElement
    public PersonnelDto getPersonnel() {
        return personnel;
    }

    public void setPersonnel(PersonnelDto personnel) {
        this.personnel = personnel;
    }

    @XmlElement
    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }
}
