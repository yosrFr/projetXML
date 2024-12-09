package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.LocalDto;
import com.example.projet.projet.modele.Dto.ReservationLocalDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.ReservationLocalXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationLocalServiceTest {
    private ReservationLocalService reservationLocalService;
    private ReservationLocalXMLUtils reservationLocalXMLUtils;
    private List<ReservationLocalDto> reservationLocalDtos;

    @BeforeEach
    public void setUp() {
        reservationLocalXMLUtils = new ReservationLocalXMLUtils();
        reservationLocalService = new ReservationLocalService(reservationLocalXMLUtils);
        reservationLocalDtos = new ArrayList<>();
        LocalDto local1 = new LocalDto("adresseLocal1", 20, 1, "nomLocal1", "numTelLocal1");
        LocalDto local2 = new LocalDto("adresseLocal2", 30, 2, "nomLocal2", "numTelLocal2");
        SessionDto session1 = new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45");
        SessionDto session2 = new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45");
        reservationLocalDtos.add(new ReservationLocalDto(1, local1, session1));
        reservationLocalDtos.add(new ReservationLocalDto(2, local2, session2));
        reservationLocalXMLUtils.marshaller(reservationLocalDtos);
    }

    @Test
    public void testAjouterReservation() {
        LocalDto local1 = new LocalDto("adresseLocal2", 30, 2, "nomLocal2", "numTelLocal2");
        SessionDto session1 = new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45");
        ReservationLocalDto newReservationLocal = new ReservationLocalDto(3, local1, session1);
        reservationLocalService.ajouterReservationLocal(newReservationLocal);
        List<ReservationLocalDto> result = reservationLocalXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(reservation -> reservation.getIdReservationLocal() == newReservationLocal.getIdReservationLocal());
        assertTrue(exist);
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(ReservationLocalXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
