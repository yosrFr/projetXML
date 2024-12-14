package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlRootElement
public class ParticipantDto extends PersonneDto {
    @NotNull
    private long idParticipant;

    public ParticipantDto() {
        super();
    }


    public ParticipantDto(String nom, String prenom, String adresse, String email, String telephone, String dateNaissance, String sexe, long idParticipant) {
        super(nom, prenom, adresse, email, telephone, dateNaissance, sexe);
        this.idParticipant = idParticipant;
    }

    @XmlElement (name = "IdPar")
    public long getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(long idParticipant) {
        this.idParticipant = idParticipant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantDto that)) return false;
        if (!super.equals(o)) return false;
        return idParticipant == that.idParticipant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idParticipant);
    }
}
