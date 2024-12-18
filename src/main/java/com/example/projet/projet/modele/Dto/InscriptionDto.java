package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

@XmlRootElement(name = "Inscriptions", namespace = "http://www.example.com/Inscriptions")
public class InscriptionDto {
    @NotNull
    private String DateInscription;
    @NotNull
    private long idInscription;
    private Boolean presence;
    private Boolean retour;
    @NotNull
    private ParticipantDto participant;
    @NotNull
    private EvenementDto evenement;
    @NotNull
    private TypeInscriptionDto typeInscription;

    public InscriptionDto() {

    }

    public InscriptionDto(String dateInscription, long idInscription, Boolean presence, Boolean retour, ParticipantDto participant, EvenementDto evenement, TypeInscriptionDto typeInscription) {
        DateInscription = dateInscription;
        this.idInscription = idInscription;
        this.presence = presence;
        this.retour = retour;
        this.participant = participant;
        this.evenement = evenement;
        this.typeInscription = typeInscription;
    }

    @XmlElement (name = "DateInscri")
    public String getDateInscription() {
        return DateInscription;
    }

    public void setDateInscription(String dateInscription) {
        DateInscription = dateInscription;
    }

    @XmlElement (name = "IdInscri")
    public long getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(long idInscription) {
        this.idInscription = idInscription;
    }

    @XmlElement (name = "Presence")
    public Boolean getPresence() {
        return presence;
    }

    public void setPresence(Boolean presence) {
        this.presence = presence;
    }

    @XmlElement (name = "Retour")
    public Boolean getRetour() {
        return retour;
    }

    public void setRetour(Boolean retour) {
        this.retour = retour;
    }

    @XmlElement (name = "Participant")
    public ParticipantDto getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantDto participant) {
        this.participant = participant;
    }

    @XmlElement (name = "Evenement")
    public EvenementDto getEvenement() {
        return evenement;
    }

    public void setEvenement(EvenementDto evenement) {
        this.evenement = evenement;
    }

    @XmlElement (name = "TypeInscription")
    public TypeInscriptionDto getTypeInscription() {
        return typeInscription;
    }

    public void setTypeInscription(TypeInscriptionDto typeInscription) {
        this.typeInscription = typeInscription;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InscriptionDto that)) return false;
        return idInscription == that.idInscription && Objects.equals(DateInscription, that.DateInscription) && Objects.equals(presence, that.presence) && Objects.equals(retour, that.retour) && Objects.equals(participant, that.participant) && Objects.equals(evenement, that.evenement) && Objects.equals(typeInscription, that.typeInscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DateInscription, idInscription, presence, retour, participant, evenement, typeInscription);
    }
}
