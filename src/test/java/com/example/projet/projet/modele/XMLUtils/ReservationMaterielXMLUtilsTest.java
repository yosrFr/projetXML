package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.MaterielDto;
import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
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

public class ReservationMaterielXMLUtilsTest {
    private ReservationMaterielXMLUtils reservationMaterielXMLUtils;
    private List<ReservationMaterielsDto> reservationMaterielsDtos;
    private List<MaterielDto> materielDtos;

    @BeforeEach
    public void setUp() {
        reservationMaterielXMLUtils = new ReservationMaterielXMLUtils();
        reservationMaterielsDtos = new ArrayList<>();
        materielDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(1, "nom1", "marque1", "modele1", new Date()));
        materielDtos.add(new MaterielDto(2, "nom2", "marque2", "modele2", new Date()));
        SessionDto session1 = new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45");
        SessionDto session2 = new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45");
        reservationMaterielsDtos.add(new ReservationMaterielsDto(1, materielDtos, session1));
        reservationMaterielsDtos.add(new ReservationMaterielsDto(2, materielDtos, session2));
    }

    @Test
    void testMarshaller() {
        reservationMaterielXMLUtils.marshaller(reservationMaterielsDtos);
        File xmlFile = new File(ReservationMaterielXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        reservationMaterielXMLUtils.marshaller(reservationMaterielsDtos);
        List<ReservationMaterielsDto> unmarshalledDtos = reservationMaterielXMLUtils.unmarshaller();
        assertEquals(reservationMaterielsDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < reservationMaterielsDtos.size(); i++) {
            assertEquals(reservationMaterielsDtos.get(i).getIdReservationMateriel(), unmarshalledDtos.get(i).getIdReservationMateriel(), "L'ID de reservation doit etre la meme");
            for (int j = 0; j < materielDtos.size(); j++) {
                assertEquals(reservationMaterielsDtos.get(i).getMateriel().get(j).getIdMateriel(), unmarshalledDtos.get(i).getMateriel().get(j).getIdMateriel(), "L'ID du materiel doit etre la meme");
                assertEquals(reservationMaterielsDtos.get(i).getMateriel().get(j).getModeleMateriel(), unmarshalledDtos.get(i).getMateriel().get(j).getModeleMateriel(), "Le modele doit etre la meme");
                assertEquals(reservationMaterielsDtos.get(i).getMateriel().get(j).getMarqueMateriel(), unmarshalledDtos.get(i).getMateriel().get(j).getMarqueMateriel(), "La marque doit etre la meme");
                assertEquals(reservationMaterielsDtos.get(i).getMateriel().get(j).getNomMateriel(), unmarshalledDtos.get(i).getMateriel().get(j).getNomMateriel(), "Le nom doit etre la meme");
                assertEquals(reservationMaterielsDtos.get(i).getMateriel().get(j).getDateAchatMateriel(), unmarshalledDtos.get(i).getMateriel().get(j).getDateAchatMateriel(), "La date d'achat doit etre la meme");
            }
            assertEquals(reservationMaterielsDtos.get(i).getSession().getIdSession(), unmarshalledDtos.get(i).getSession().getIdSession(), "L'ID de session doit etre la meme");
            assertEquals(reservationMaterielsDtos.get(i).getSession().getTitreSession(), unmarshalledDtos.get(i).getSession().getTitreSession(), "Le titre de session doit etre la meme");
            assertEquals(reservationMaterielsDtos.get(i).getSession().getDateSession(), unmarshalledDtos.get(i).getSession().getDateSession(), "La date de session doit etre la meme");
            assertEquals(reservationMaterielsDtos.get(i).getSession().getHeureDebutSession(), unmarshalledDtos.get(i).getSession().getHeureDebutSession(), "L'heure de debut doit etre la meme");
            assertEquals(reservationMaterielsDtos.get(i).getSession().getHeureFinSession(), unmarshalledDtos.get(i).getSession().getHeureFinSession(), "L'heure de fin doit etre la meme");
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(ReservationMaterielXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
