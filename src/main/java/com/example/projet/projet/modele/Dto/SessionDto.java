package com.example.projet.projet.modele.Dto;

import com.example.projet.projet.modele.XMLUtils.DateAdapter;
import com.example.projet.projet.modele.XMLUtils.LocalTimeAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalTime;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SessionDto {
    private long idSession;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateSession;
    private String titreSession;
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime heureDebutSession;
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime heureFinSession;

    public SessionDto() {

    }

    public SessionDto(long idSession, Date dateSession, String titreSession, LocalTime heureDebutSession, LocalTime heureFinSession) {
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

    @XmlElement (name = "DateSession")
    @XmlJavaTypeAdapter(DateAdapter.class)
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

    @XmlElement (name = "heureDebutSession")
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    public LocalTime getHeureDebutSession() {
        return heureDebutSession;
    }

    public void setHeureDebutSession(LocalTime heureDebutSession) {
        this.heureDebutSession = heureDebutSession;
    }

    @XmlElement (name = "heureFinSession")
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    public LocalTime getHeureFinSession() {
        return heureFinSession;
    }

    public void setHeureFinSession(LocalTime heureFinSession) {
        this.heureFinSession = heureFinSession;
    }

}
