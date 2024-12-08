package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.LocalDto;
import com.example.projet.projet.modele.Dto.ReservationLocalDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationLocalXMLUtilsTest {
    private ReservationLocalXMLUtils reservationLocalXMLUtils;
    private List<ReservationLocalDto> reservationLocalDtos;

    @BeforeEach
    public void setUp() {
        reservationLocalXMLUtils = new ReservationLocalXMLUtils();
        reservationLocalDtos = new ArrayList<>();
        LocalDto local1 = new LocalDto("adresseLocal1", 20, 1, "nomLocal1", "numTelLocal1");
        LocalDto local2 = new LocalDto("adresseLocal2", 30, 2, "nomLocal2", "numTelLocal2");
        SessionDto session1 = new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45");
        SessionDto session2 = new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45");
        reservationLocalDtos.add(new ReservationLocalDto(1, local1, session1));
        reservationLocalDtos.add(new ReservationLocalDto(2, local2, session2));
    }

    @Test
    void testMarshaller() {
        reservationLocalXMLUtils.marshaller(reservationLocalDtos);
        File xmlFile = new File(ReservationLocalXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        reservationLocalXMLUtils.marshaller(reservationLocalDtos);
        List<ReservationLocalDto> unmarshalledDtos = reservationLocalXMLUtils.unmarshaller();
        assertEquals(reservationLocalDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0 ; i < reservationLocalDtos.size() ; i++) {
            assertEquals(reservationLocalDtos.get(i).getIdReservationLocal(), unmarshalledDtos.get(i).getIdReservationLocal(), "L'ID de reservation doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getLocal().getIdLocal(), unmarshalledDtos.get(i).getLocal().getIdLocal(), "L'ID du local doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getLocal().getNomLocal(), unmarshalledDtos.get(i).getLocal().getNomLocal(), "Le nom du local doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getLocal().getAdresseLocal(), unmarshalledDtos.get(i).getLocal().getAdresseLocal(), "L'adresse du local doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getLocal().getNumTelLocal(), unmarshalledDtos.get(i).getLocal().getNumTelLocal(), "Le numero de telephone du local doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getLocal().getCapaciteLocal(), unmarshalledDtos.get(i).getLocal().getCapaciteLocal(), "La capacité du local doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getSession().getIdSession(), unmarshalledDtos.get(i).getSession().getIdSession(), "L'ID de session doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getSession().getTitreSession(), unmarshalledDtos.get(i).getSession().getTitreSession(), "Le titre de session doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getSession().getDateSession(), unmarshalledDtos.get(i).getSession().getDateSession(), "La date de session doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getSession().getHeureDebutSession(), unmarshalledDtos.get(i).getSession().getHeureDebutSession(), "L'heure de debut de session doit etre la meme");
            assertEquals(reservationLocalDtos.get(i).getSession().getHeureFinSession(), unmarshalledDtos.get(i).getSession().getHeureFinSession(), "L'heure de fin de session doit etre la meme");
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(ReservationLocalXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
