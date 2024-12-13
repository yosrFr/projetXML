package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlRootElement
public class InscriptionDto {
    @NotNull
    private Date DateInscription;
    @NotNull
    private long idInscription;
    private Boolean presence;
    private Boolean retour;
    @NotNull
    private ParticipantDto participant;
    @NotNull
    private EvenementDto evenement;

    public InscriptionDto() {

    }

    public InscriptionDto(Date dateInscription, long idInscription, Boolean presence, Boolean retour, ParticipantDto participant, EvenementDto evenement) {
        DateInscription = dateInscription;
        this.idInscription = idInscription;
        this.presence = presence;
        this.retour = retour;
        this.participant = participant;
        this.evenement = evenement;
    }

    @XmlElement
    public Date getDateInscription() {
        return DateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        DateInscription = dateInscription;
    }

    @XmlElement
    public long getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(long idInscription) {
        this.idInscription = idInscription;
    }

    @XmlElement
    public Boolean getPresence() {
        return presence;
    }

    public void setPresence(Boolean presence) {
        this.presence = presence;
    }

    @XmlElement
    public Boolean getRetour() {
        return retour;
    }

    public void setRetour(Boolean retour) {
        this.retour = retour;
    }

    @XmlElement
    public ParticipantDto getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantDto participant) {
        this.participant = participant;
    }

    @XmlElement
    public EvenementDto getEvenement() {
        return evenement;
    }

    public void setEvenement(EvenementDto evenement) {
        this.evenement = evenement;
    }

}
