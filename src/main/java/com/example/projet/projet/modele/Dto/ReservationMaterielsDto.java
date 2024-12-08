package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlRootElement
public class ReservationMaterielsDto {
    private long idReservationMateriel;
    private List<MaterielDto> materiel;
    private SessionDto session;

    public ReservationMaterielsDto() {

    }

    public ReservationMaterielsDto(long idReservationMateriel, List<MaterielDto> materiel, SessionDto session) {
        this.idReservationMateriel = idReservationMateriel;
        this.materiel = materiel;
        this.session = session;
    }

    @XmlElement
    public long getIdReservationMateriel() {
        return idReservationMateriel;
    }

    public void setIdReservationMateriel(long idReservationMateriel) {
        this.idReservationMateriel = idReservationMateriel;
    }

    @XmlElement
    public List<MaterielDto> getMateriel() {
        return materiel;
    }

    public void setMateriel(List<MaterielDto> materiel) {
        this.materiel = materiel;
    }

    @XmlElement
    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }

}
