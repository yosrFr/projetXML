package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class EvenementDto {
    private long idEvenement;
    private String titreEvenement;
    private String descriptionEvenement;
    private String dateDebutEvenement;
    private String dateFinEvenement;
    private int NombreParticipantsEstime;
    private int NombreParticipantsMaximal;
    private List<SessionDto> sessions;

    public EvenementDto() {
        super();
        sessions = new ArrayList<SessionDto>();
    }

    public EvenementDto(long idEvenement, String titreEvenement, String descriptionEvenement, String dateDebutEvenement, String dateFinEvenement, int nombreParticipantsEstime, int nombreParticipantsMaximal, List<SessionDto> sessions) {
        this.idEvenement = idEvenement;
        this.titreEvenement = titreEvenement;
        this.descriptionEvenement = descriptionEvenement;
        this.dateDebutEvenement = dateDebutEvenement;
        this.dateFinEvenement = dateFinEvenement;
        NombreParticipantsEstime = nombreParticipantsEstime;
        NombreParticipantsMaximal = nombreParticipantsMaximal;
        this.sessions = sessions;
    }

    @XmlElement
    public long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(long idEvenement) {
        this.idEvenement = idEvenement;
    }

    @XmlElement
    public String getTitreEvenement() {
        return titreEvenement;
    }

    public void setTitreEvenement(String titreEvenement) {
        this.titreEvenement = titreEvenement;
    }

    @XmlElement
    public String getDescriptionEvenement() {
        return descriptionEvenement;
    }

    public void setDescriptionEvenement(String descriptionEvenement) {
        this.descriptionEvenement = descriptionEvenement;
    }

    @XmlElement
    public String getDateDebutEvenement() {
        return dateDebutEvenement;
    }

    public void setDateDebutEvenement(String dateDebutEvenement) {
        this.dateDebutEvenement = dateDebutEvenement;
    }

    @XmlElement
    public String getDateFinEvenement() {
        return dateFinEvenement;
    }

    public void setDateFinEvenement(String dateFinEvenement) {
        this.dateFinEvenement = dateFinEvenement;
    }

    @XmlElement
    public int getNombreParticipantsEstime() {
        return NombreParticipantsEstime;
    }

    public void setNombreParticipantsEstime(int nombreParticipantsEstime) {
        NombreParticipantsEstime = nombreParticipantsEstime;
    }

    @XmlElement
    public int getNombreParticipantsMaximal() {
        return NombreParticipantsMaximal;
    }

    public void setNombreParticipantsMaximal(int nombreParticipantsMaximal) {
        NombreParticipantsMaximal = nombreParticipantsMaximal;
    }

    @XmlElement
    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }

}
