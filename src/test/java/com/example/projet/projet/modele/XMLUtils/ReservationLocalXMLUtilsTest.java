package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.LocalDto;
import com.example.projet.projet.modele.Dto.ReservationLocalDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationLocalXMLUtilsTest {
    private final ReservationLocalXMLUtils reservationLocalXMLUtils = new ReservationLocalXMLUtils();
    private List<ReservationLocalDto> reservationLocalDtos;

    @BeforeEach
    public void setUp() {
        reservationLocalDtos = new ArrayList<>();
        LocalDto local1 = new LocalDto("1 Rue Centrale", 50, 101, "Salle A", "+21612345678");
        LocalDto local2 = new LocalDto("2 Rue Centrale", 30, 102, "Salle B", "+21687654321");
        SessionDto session1 = new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00");
        SessionDto session2 = new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00");
        reservationLocalDtos.add(new ReservationLocalDto(1, local1, session1));
        reservationLocalDtos.add(new ReservationLocalDto(2, local2, session2));
    }

    @Test
    void testMarshaller() {
        reservationLocalXMLUtils.marshaller(reservationLocalDtos);
        File xmlFile = new File(ReservationLocalXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        reservationLocalXMLUtils.marshaller(reservationLocalDtos);
        List<ReservationLocalDto> unmarshalledDtos = reservationLocalXMLUtils.unmarshaller();
        assertEquals(reservationLocalDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0 ; i < reservationLocalDtos.size() ; i++) {
            assertTrue(unmarshalledDtos.get(i).equals(reservationLocalDtos.get(i)));
        }
    }
/*
    @AfterEach
    void tearDown() {
        File file = new File(ReservationLocalXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }*/
}
