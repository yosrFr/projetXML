package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

@XmlRootElement
public class ReservationLocalDto {
    @NotNull
    private long idReservationLocal;
    @NotNull
    private LocalDto local;
    @NotNull
    private SessionDto session;

    public ReservationLocalDto() {}

    public ReservationLocalDto(long idReservationLocal, LocalDto local, SessionDto session) {
        this.idReservationLocal = idReservationLocal;
        this.local = local;
        this.session = session;
    }

    @XmlElement (name = "IdReservLocal")
    public long getIdReservationLocal() {
        return idReservationLocal;
    }

    public void setIdReservationLocal(long idReservationLocal) {
        this.idReservationLocal = idReservationLocal;
    }

    @XmlElement (name = "local")
    public LocalDto getLocal() {
        return local;
    }

    public void setLocal(LocalDto local) {
        this.local = local;
    }

    @XmlElement (name = "session")
    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReservationLocalDto that)) return false;
        return idReservationLocal == that.idReservationLocal && Objects.equals(local, that.local) && Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReservationLocal, local, session);
    }
}
