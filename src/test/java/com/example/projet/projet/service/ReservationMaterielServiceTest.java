package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.MaterielDto;
import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.ReservationMaterielXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

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
        materielDtos.add(new MaterielDto(101, "datashow", "BenQ", "BenQ W1800i", "2022-12-12"));
        materielDtos.add(new MaterielDto(102, "TV", "LG", "OLED55B4PUA", "2022-12-23"));
        SessionDto session1 = new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00");
        SessionDto session2 = new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00");
        reservationMaterielsDtos.add(new ReservationMaterielsDto(1, materielDtos, session1));
        reservationMaterielsDtos.add(new ReservationMaterielsDto(2, materielDtos, session2));
        reservationMaterielXMLUtils.marshaller(reservationMaterielsDtos);
    }

    @Test
    public void testAjouterReservationMateriel() {
        reservationMaterielsDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(1, "nom1", "marque1", "modele1", "2024-11-10"));
        materielDtos.add(new MaterielDto(2, "nom2", "marque2", "modele2", "2024-11-10"));
        SessionDto session1 = new SessionDto(1, "2024-11-11", "titreSession1", "09:45", "09:45");
        ReservationMaterielsDto reservationMaterielDto = new ReservationMaterielsDto(3, materielDtos, session1);
        reservationMaterielService.ajouterReservationMateriel(reservationMaterielDto);
        List<ReservationMaterielsDto> result = reservationMaterielXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(reservation -> reservation.getIdReservationMateriel() == reservationMaterielDto.getIdReservationMateriel());
        assertTrue(exist);
    }

    @Test
    public void testEstReservé() {
        boolean result = reservationMaterielService.estReservé(102, "09:30", "11:30", "2024-12-11");
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
