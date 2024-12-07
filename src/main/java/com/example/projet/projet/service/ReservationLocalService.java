package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.ReservationLocalDto;
import com.example.projet.projet.modele.XMLUtils.ReservationLocalXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationLocalService {
    @Autowired
    private ReservationLocalXMLUtils reservationLocalXMLUtils;

    public ReservationLocalService(ReservationLocalXMLUtils reservationLocalXMLUtils) {
        this.reservationLocalXMLUtils = reservationLocalXMLUtils;
    }

    public void ajouterReservationLocal (ReservationLocalDto reservationLocal){
        List<ReservationLocalDto> list = reservationLocalXMLUtils.unmarshaller();
        list.add(reservationLocal);
        reservationLocalXMLUtils.marshaller(list);
    }
}
