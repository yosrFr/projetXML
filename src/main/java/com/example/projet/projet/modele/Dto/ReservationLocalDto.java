package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement
public class ReservationLocalDto {
    private long idReservationLocal;
    private LocalDto local;
    private SessionDto session;

    public ReservationLocalDto() {}

    public ReservationLocalDto(long idReservationLocal, LocalDto local, SessionDto session) {
        this.idReservationLocal = idReservationLocal;
        this.local = local;
        this.session = session;
    }

    @XmlElement
    public long getIdReservationLocal() {
        return idReservationLocal;
    }

    public void setIdReservationLocal(long idReservationLocal) {
        this.idReservationLocal = idReservationLocal;
    }

    @XmlElement
    public LocalDto getLocal() {
        return local;
    }

    public void setLocal(LocalDto local) {
        this.local = local;
    }

    @XmlElement
    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }

}
