package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "ReservationsMateriaux", namespace = "http://www.example.com/ReservationsMateriaux")
public class ReservationMaterielsDto {
    @NotNull
    private long idReservationMateriel;
    @NotNull
    private List<MaterielDto> materiaux;
    @NotNull
    private SessionDto session;

    public ReservationMaterielsDto() {

    }

    public ReservationMaterielsDto(long idReservationMateriel, List<MaterielDto> materiaux, SessionDto session) {
        this.idReservationMateriel = idReservationMateriel;
        this.materiaux = materiaux;
        this.session = session;
    }

    @XmlElement (name = "IdReservMat")
    public long getIdReservationMateriel() {
        return idReservationMateriel;
    }

    public void setIdReservationMateriel(long idReservationMateriel) {
        this.idReservationMateriel = idReservationMateriel;
    }

    @XmlElement (name = "Materiaux")
    public List<MaterielDto> getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(List<MaterielDto> materiaux) {
        this.materiaux = materiaux;
    }

    @XmlElement (name = "Session")
    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReservationMaterielsDto that)) return false;
        return idReservationMateriel == that.idReservationMateriel && Objects.equals(materiaux, that.materiaux) && Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReservationMateriel, materiaux, session);
    }
}
