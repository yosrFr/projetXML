package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.ReservationLocalDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "ReservationsLocal")
public class ReservationLocalWrapper {
    private List<ReservationLocalDto> reservationsLocal;

    public ReservationLocalWrapper() {

    }

    public ReservationLocalWrapper(List<ReservationLocalDto> reservationsLocal) {
        this.reservationsLocal = reservationsLocal;
    }

    @XmlElement(name = "ReservationLocal")
    public List<ReservationLocalDto> getReservationsLocal() {
        return reservationsLocal;
    }

    public void setReservationsLocal(List<ReservationLocalDto> reservationsLocal) {
        this.reservationsLocal = reservationsLocal;
    }
}
