package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlRootElement
public class InscriptionDto {
    private Date DateInscription;
    private long idInscription;
    private boolean presence;
    private boolean retour;
    private ParticipantDto participant;
    private EvenementDto evenement;

    public InscriptionDto() {

    }

    public InscriptionDto(Date dateInscription, long idInscription, boolean presence, boolean retour, ParticipantDto participant, EvenementDto evenement) {
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
    public boolean getPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    @XmlElement
    public boolean getRetour() {
        return retour;
    }

    public void setRetour(boolean retour) {
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
