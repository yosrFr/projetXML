package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.ReservationMaterielXMLUtils;
import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class ReservationMaterielService {
    @Autowired
    private ReservationMaterielXMLUtils reservationMaterielXMLUtils;

    public ReservationMaterielService(ReservationMaterielXMLUtils reservationMaterielXMLUtils) {
        this.reservationMaterielXMLUtils = reservationMaterielXMLUtils;
    }

    public void ajouterReservationMateriel (ReservationMaterielsDto reservationMateriel){
        List<ReservationMaterielsDto> list = reservationMaterielXMLUtils.unmarshaller();
        list.add(reservationMateriel);
        reservationMaterielXMLUtils.marshaller(list);
    }

    public boolean estReservé (long idMateriel, String tempsDebut, String tempsFin, Date date){
        LocalTime debut = LocalTime.parse(tempsDebut, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime fin = LocalTime.parse(tempsFin, DateTimeFormatter.ofPattern("HH:mm"));
        List<ReservationMaterielsDto> list = reservationMaterielXMLUtils.unmarshaller();
        return list.stream()
                .filter(reservationMateriels -> reservationMateriels.getMateriel().stream()
                        .anyMatch(materielDto -> materielDto.getIdMateriel() == idMateriel))
                .anyMatch(reservation ->
                        reservation.getSession().getDateSession().equals(date) &&
                        !debut.isAfter(LocalTime.parse(reservation.getSession().getHeureFinSession())) &&
                                !fin.isBefore(LocalTime.parse(reservation.getSession().getHeureDebutSession())));
    }
}
