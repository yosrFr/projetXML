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
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        sessionXMLUtils.marshaller(SessionDtos);
        List<SessionDto> unmarshalledDtos = sessionXMLUtils.unmarshaller();
        assertEquals(SessionDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(SessionDtos.get(0).getIdSession(), unmarshalledDtos.get(0).getIdSession(), "The ID should match");
        assertEquals(SessionDtos.get(0).getTitreSession(), unmarshalledDtos.get(0).getTitreSession(), "The name should match");
        assertEquals(SessionDtos.get(0).getDateSession(), unmarshalledDtos.get(0).getDateSession(), "The date should match");
        assertEquals(SessionDtos.get(0).getHeureDebutSession(), unmarshalledDtos.get(0).getHeureDebutSession(), "The time should match");
        assertEquals(SessionDtos.get(0).getHeureFinSession(), unmarshalledDtos.get(0).getHeureFinSession(), "The time should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(SessionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }

}
