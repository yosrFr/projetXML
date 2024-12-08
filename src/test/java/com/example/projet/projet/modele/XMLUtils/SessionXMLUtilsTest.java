package com.example.projet.projet.modele.XMLUtils;

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

public class SessionXMLUtilsTest {
    private SessionXMLUtils sessionXMLUtils;
    private List<SessionDto> SessionDtos;

    @BeforeEach
    public void setUp() {
        sessionXMLUtils = new SessionXMLUtils();
        SessionDtos = new ArrayList<>();
        SessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        SessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
    }

    @Test
    public void testMarshaller() {
        sessionXMLUtils.marshaller(SessionDtos);
        File xmlFile = new File(SessionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        sessionXMLUtils.marshaller(SessionDtos);
        List<SessionDto> unmarshalledDtos = sessionXMLUtils.unmarshaller();
        assertEquals(SessionDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for (int i = 0; i < SessionDtos.size(); i++) {
            assertEquals(SessionDtos.get(i).getIdSession(), unmarshalledDtos.get(i).getIdSession(), "L'ID doit etre la meme");
            assertEquals(SessionDtos.get(i).getTitreSession(), unmarshalledDtos.get(i).getTitreSession(), "Le titre doit etre la meme");
            assertEquals(SessionDtos.get(i).getDateSession(), unmarshalledDtos.get(i).getDateSession(), "La date doit etre la meme");
            assertEquals(SessionDtos.get(i).getHeureDebutSession(), unmarshalledDtos.get(i).getHeureDebutSession(), "L'heure de debut doit etre la meme");
            assertEquals(SessionDtos.get(i).getHeureFinSession(), unmarshalledDtos.get(i).getHeureFinSession(), "L'heure de fin doit etre la meme");
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(SessionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }

}
