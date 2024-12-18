package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

@XmlRootElement(name = "Sessions", namespace = "http://www.example.com/Sessions")
public class SessionDto {
    @NotNull
    private long idSession;
    @NotNull
    private String dateSession;
    @NotNull
    private String titreSession;
    @NotNull
    private String heureDebutSession;
    @NotNull
    private String heureFinSession;

    public SessionDto() {

    }

    public SessionDto(long idSession, String dateSession, String titreSession, String heureDebutSession, String heureFinSession) {
        this.idSession = idSession;
        this.dateSession = dateSession;
        this.titreSession = titreSession;
        this.heureDebutSession = heureDebutSession;
        this.heureFinSession = heureFinSession;
    }
    @XmlElement(name = "IdSession")
    public long getIdSession() {
        return idSession;
    }

    public void setIdSession(long idSession) {
        this.idSession = idSession;
    }

    @XmlElement(name = "DateSession")
    public String getDateSession() {
        return dateSession;
    }

    public void setDateSession(String dateSession) {
        this.dateSession = dateSession;
    }

    @XmlElement(name = "TitreSession")
    public String getTitreSession() {
        return titreSession;
    }

    public void setTitreSession(String titreSession) {
        this.titreSession = titreSession;
    }

    @XmlElement(name = "HeureDebutSession")
    public String getHeureDebutSession() {
        return heureDebutSession;
    }

    public void setHeureDebutSession(String heureDebutSession) {
        this.heureDebutSession = heureDebutSession;
    }

    @XmlElement(name = "HeureFinSession")
    public String getHeureFinSession() {
        return heureFinSession;
    }

    public void setHeureFinSession(String heureFinSession) {
        this.heureFinSession = heureFinSession;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SessionDto that)) return false;
        return idSession == that.idSession && Objects.equals(dateSession, that.dateSession) && Objects.equals(titreSession, that.titreSession) && Objects.equals(heureDebutSession, that.heureDebutSession) && Objects.equals(heureFinSession, that.heureFinSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSession, dateSession, titreSession, heureDebutSession, heureFinSession);
    }
}
