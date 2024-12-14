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
        LocalDto local1 = new LocalDto("1 Rue Centrale", 50, 101, "Salle A", "+21612345678");
        LocalDto local2 = new LocalDto("2 Rue Centrale", 30, 102, "Salle B", "+21687654321");
        SessionDto session1 = new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00");
        SessionDto session2 = new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00");
        reservationLocalDtos.add(new ReservationLocalDto(1, local1, session1));
        reservationLocalDtos.add(new ReservationLocalDto(2, local2, session2));
        reservationLocalXMLUtils.marshaller(reservationLocalDtos);
    }

    @Test
    public void testAjouterReservation() {
        LocalDto local1 = new LocalDto("adresseLocal2", 30, 2, "nomLocal2", "numTelLocal2");
        SessionDto session1 = new SessionDto(2, "2023-12-31", "titreSession2", "09:45", "09:45");
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
