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
    private String NombreParticipantsEstime;
    private String NombrePaerticipantsMaximal;
    private List<SessionDto> sessions;

    public EvenementDto() {
        super();
        sessions = new ArrayList<SessionDto>();
    }

    public EvenementDto(long idEvenement, String titreEvenement, String descriptionEvenement, String dateDebutEvenement, String dateFinEvenement, String nombreParticipantsEstime, String nombrePaerticipantsMaximal, List<SessionDto> sessions) {
        this.idEvenement = idEvenement;
        this.titreEvenement = titreEvenement;
        this.descriptionEvenement = descriptionEvenement;
        this.dateDebutEvenement = dateDebutEvenement;
        this.dateFinEvenement = dateFinEvenement;
        NombreParticipantsEstime = nombreParticipantsEstime;
        NombrePaerticipantsMaximal = nombrePaerticipantsMaximal;
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
    public String getNombreParticipantsEstime() {
        return NombreParticipantsEstime;
    }

    public void setNombreParticipantsEstime(String nombreParticipantsEstime) {
        NombreParticipantsEstime = nombreParticipantsEstime;
    }

    @XmlElement
    public String getNombrePaerticipantsMaximal() {
        return NombrePaerticipantsMaximal;
    }

    public void setNombrePaerticipantsMaximal(String nombrePaerticipantsMaximal) {
        NombrePaerticipantsMaximal = nombrePaerticipantsMaximal;
    }

    @XmlElement
    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }

}
