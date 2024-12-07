package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.ReservationMaterielXMLUtils;
import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
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

    public boolean estReservé (long idMateriel, LocalTime tempsDebut, LocalTime tempsFin, Date date){
        List<ReservationMaterielsDto> list = reservationMaterielXMLUtils.unmarshaller();
        return list.stream()
                .filter(reservationMateriels -> reservationMateriels.getMateriel()
                        .stream().anyMatch(materielDto -> materielDto.getIdMateriel() == idMateriel))
                .anyMatch(reservationMateriels ->
                        !reservationMateriels.getSession().getDateSession().equals(date) &&
                        tempsDebut.isAfter(reservationMateriels.getSession().getHeureFinSession()) &
                        tempsFin.isBefore(reservationMateriels.getSession().getHeureDebutSession()));
    }

}
