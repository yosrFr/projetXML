package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlRootElement
public class ParticipantDto extends PersonneDto {
    private long idParticipant;

    public ParticipantDto() {
        super();
    }

    public ParticipantDto(String nom, String prenom, String adresse, String email, String telephone, Date dateNaissance, String sexe, long idParticipant) {
        super(nom, prenom, adresse, email, telephone, dateNaissance, sexe);
        this.idParticipant = idParticipant;
    }

    @XmlElement
    public long getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(long idParticipant) {
        this.idParticipant = idParticipant;
    }

}
