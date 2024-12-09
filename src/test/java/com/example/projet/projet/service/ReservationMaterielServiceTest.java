package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.MaterielDto;
import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.ReservationMaterielXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationMaterielServiceTest {
    private ReservationMaterielService reservationMaterielService;
    private ReservationMaterielXMLUtils reservationMaterielXMLUtils;
    private List<ReservationMaterielsDto> reservationMaterielsDtos;
    private List<MaterielDto> materielDtos;

    @BeforeEach
    public void setUp() {
        reservationMaterielXMLUtils = new ReservationMaterielXMLUtils();
        reservationMaterielService = new ReservationMaterielService(reservationMaterielXMLUtils);
        reservationMaterielsDtos = new ArrayList<>();
        materielDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(1, "nom1", "marque1", "modele1", new Date()));
        materielDtos.add(new MaterielDto(2, "nom2", "marque2", "modele2", new Date()));
        SessionDto session1 = new SessionDto(1, new Date(), "titreSession1", "09:00", "10:00");
        SessionDto session2 = new SessionDto(2, new Date(), "titreSession2", "12:45", "12:00");
        reservationMaterielsDtos.add(new ReservationMaterielsDto(1, materielDtos, session1));
        reservationMaterielsDtos.add(new ReservationMaterielsDto(2, materielDtos, session2));
        reservationMaterielXMLUtils.marshaller(reservationMaterielsDtos);
    }

    @Test
    public void testAjouterReservationMateriel() {
        reservationMaterielsDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(1, "nom1", "marque1", "modele1", new Date()));
        materielDtos.add(new MaterielDto(2, "nom2", "marque2", "modele2", new Date()));
        SessionDto session1 = new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45");
        ReservationMaterielsDto reservationMaterielDto = new ReservationMaterielsDto(3, materielDtos, session1);
        reservationMaterielService.ajouterReservationMateriel(reservationMaterielDto);
        List<ReservationMaterielsDto> result = reservationMaterielXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(reservation -> reservation.getIdReservationMateriel() == reservationMaterielDto.getIdReservationMateriel());
        assertTrue(exist);
    }

    @Test
    public void testEstReservé() {
        boolean result = reservationMaterielService.estReservé(2, "09:30", "11:30", new Date());
        assertTrue(result);
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(ReservationMaterielXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
