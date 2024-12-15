package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.MaterielDto;
import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationMaterielXMLUtilsTest {
    private final ReservationMaterielXMLUtils reservationMaterielXMLUtils = new ReservationMaterielXMLUtils();
    private List<ReservationMaterielsDto> reservationMaterielsDtos;
    private List<MaterielDto> materielDtos;

    @BeforeEach
    public void setUp() {
        reservationMaterielsDtos = new ArrayList<>();
        materielDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(101, "datashow", "BenQ", "BenQ W1800i", "2022-12-12"));
        materielDtos.add(new MaterielDto(102, "TV", "LG", "OLED55B4PUA", "2022-12-23"));
        SessionDto session1 = new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00");
        SessionDto session2 = new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00");
        reservationMaterielsDtos.add(new ReservationMaterielsDto(1, materielDtos, session1));
        reservationMaterielsDtos.add(new ReservationMaterielsDto(2, materielDtos, session2));
    }

    @Test
    void testMarshaller() {
        reservationMaterielXMLUtils.marshaller(reservationMaterielsDtos);
        File xmlFile = new File(ReservationMaterielXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        reservationMaterielXMLUtils.marshaller(reservationMaterielsDtos);
        List<ReservationMaterielsDto> unmarshalledDtos = reservationMaterielXMLUtils.unmarshaller();
        assertEquals(reservationMaterielsDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < reservationMaterielsDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(reservationMaterielsDtos.get(i)));
        }
    }
/*
    @AfterEach
    void tearDown() {
        File file = new File(ReservationMaterielXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }*/
}
