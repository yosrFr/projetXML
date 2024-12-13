package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Date;

@XmlRootElement
public class SessionDto {
    @NotNull
    private long idSession;
    @NotNull
    private Date dateSession;
    @NotNull
    private String titreSession;
    @NotNull
    private String heureDebutSession;
    @NotNull
    private String heureFinSession;

    public SessionDto() {

    }

    public SessionDto(long idSession, Date dateSession, String titreSession, String heureDebutSession, String heureFinSession) {
        this.idSession = idSession;
        this.dateSession = dateSession;
        this.titreSession = titreSession;
        this.heureDebutSession = heureDebutSession;
        this.heureFinSession = heureFinSession;
    }
    @XmlElement
    public long getIdSession() {
        return idSession;
    }

    public void setIdSession(long idSession) {
        this.idSession = idSession;
    }

    @XmlElement
    public Date getDateSession() {
        return dateSession;
    }

    public void setDateSession(Date dateSession) {
        this.dateSession = dateSession;
    }

    @XmlElement
    public String getTitreSession() {
        return titreSession;
    }

    public void setTitreSession(String titreSession) {
        this.titreSession = titreSession;
    }

    @XmlElement
    public String getHeureDebutSession() {
        return heureDebutSession;
    }

    public void setHeureDebutSession(String heureDebutSession) {
        this.heureDebutSession = heureDebutSession;
    }

    @XmlElement
    public String getHeureFinSession() {
        return heureFinSession;
    }

    public void setHeureFinSession(String heureFinSession) {
        this.heureFinSession = heureFinSession;
    }

}
