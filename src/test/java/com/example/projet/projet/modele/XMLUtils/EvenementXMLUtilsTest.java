package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.EvenementDto;
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

public class EvenementXMLUtilsTest {
    private EvenementXMLUtils evenementXMLUtils;
    private List<EvenementDto> evenementDtos;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        evenementXMLUtils = new EvenementXMLUtils();
        evenementDtos = new ArrayList<>();
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        evenementDtos.add(new EvenementDto(1, "titreEvenement1", "descriptionEvenement1", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos));
        evenementDtos.add(new EvenementDto(2, "titreEvenement2", "descriptionEvenement2", "dateDebutEvenement2", "dateFinEvenement2", 20, 50, sessionDtos));
    }

    @Test
    void testMarshaller() {
        evenementXMLUtils.marshaller(evenementDtos);
        File xmlFile = new File(EvenementXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    void testUnmarshaller() {
        evenementXMLUtils.marshaller(evenementDtos);
        List<EvenementDto> unmarshalledDtos = evenementXMLUtils.unmarshaller();
        assertEquals(evenementDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < evenementDtos.size(); i++) {
            assertEquals(evenementDtos.get(i).getIdEvenement(), unmarshalledDtos.get(i).getIdEvenement(), "L'ID de l'evenement doit etre la meme");
            assertEquals(evenementDtos.get(i).getTitreEvenement(), unmarshalledDtos.get(i).getTitreEvenement(), "Le titre de l'evenement doit etre le meme");
            assertEquals(evenementDtos.get(i).getDescriptionEvenement(), unmarshalledDtos.get(i).getDescriptionEvenement(), "La description doit etre la meme");
            assertEquals(evenementDtos.get(i).getDateDebutEvenement(), unmarshalledDtos.get(i).getDateDebutEvenement(), "La date de debut doit etre la meme");
            assertEquals(evenementDtos.get(i).getDateFinEvenement(), unmarshalledDtos.get(i).getDateFinEvenement(), "La date de fin doit etre la meme");
            assertEquals(evenementDtos.get(i).getNombreParticipantsMaximal(), unmarshalledDtos.get(i).getNombreParticipantsMaximal(), "Le nombre de participant maximal doit etre la meme");
            assertEquals(evenementDtos.get(i).getNombreParticipantsEstime(), unmarshalledDtos.get(i).getNombreParticipantsEstime(), "Le nombre de participant estime doit etre la meme");
            for(int j = 0; j < sessionDtos.size(); j++) {
                assertEquals(evenementDtos.get(i).getSessions().get(j).getIdSession(), unmarshalledDtos.get(i).getSessions().get(j).getIdSession(), "L'ID de la session doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getTitreSession(), unmarshalledDtos.get(i).getSessions().get(j).getTitreSession(), "Le titre de la session doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getDateSession(), unmarshalledDtos.get(i).getSessions().get(j).getDateSession(), "La date de la session doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getHeureDebutSession(), unmarshalledDtos.get(i).getSessions().get(j).getHeureDebutSession(), "L'heure de debut doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getHeureFinSession(), unmarshalledDtos.get(i).getSessions().get(j).getHeureFinSession(), "L'heure de fin doit etre la meme");
            }
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(EvenementXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
