package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "ReservationsMateriels")
public class ReservationMaterielWrapper {
    private List<ReservationMaterielsDto> reservationMateriels;

    public ReservationMaterielWrapper() {

    }

    public ReservationMaterielWrapper(List<ReservationMaterielsDto> reservationMateriels) {
        this.reservationMateriels = reservationMateriels;
    }

    @XmlElement(name = "ReservationMateriels")
    public List<ReservationMaterielsDto> getReservationMateriels() {
        return reservationMateriels;
    }

    public void setReservationMateriels(List<ReservationMaterielsDto> reservationMateriels) {
        this.reservationMateriels = reservationMateriels;
    }
}
