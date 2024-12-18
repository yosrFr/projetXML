package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@XmlRootElement(name = "AffectationsPersonnel", namespace = "http://www.example.com/AffectationsPersonnel")
public class AffectationPersonnelDto {
    @NotNull
    private long idAffectationPersonnel;
    @NotNull
    private PersonnelDto personnel;
    @NotNull
    private SessionDto session;

    public AffectationPersonnelDto() {

    }

    public AffectationPersonnelDto(long idAffectationPersonnel, PersonnelDto personnel, SessionDto session) {
        this.idAffectationPersonnel = idAffectationPersonnel;
        this.personnel = personnel;
        this.session = session;
    }

    @XmlElement (name = "IdAffectation")
    public long getIdAffectationPersonnel() {
        return idAffectationPersonnel;
    }

    public void setIdAffectationPersonnel(long idAffectationPersonnel) {
        this.idAffectationPersonnel = idAffectationPersonnel;
    }

    @XmlElement (name = "Personnel")
    public PersonnelDto getPersonnel() {
        return personnel;
    }

    public void setPersonnel(PersonnelDto personnel) {
        this.personnel = personnel;
    }

    @XmlElement (name = "Session")
    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AffectationPersonnelDto that)) return false;
        return idAffectationPersonnel == that.idAffectationPersonnel && Objects.equals(personnel, that.personnel) && Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAffectationPersonnel, personnel, session);
    }
}
