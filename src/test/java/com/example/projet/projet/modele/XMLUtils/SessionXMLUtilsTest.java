package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionXMLUtilsTest {
    private final SessionXMLUtils sessionXMLUtils = new SessionXMLUtils();
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00"));
        sessionDtos.add(new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00"));
        sessionDtos.add(new SessionDto(33, "2024-12-13", " Conférence internationale sur les maladies rares et les médicaments orphelins (Rare Diseases 2025)", "09:00", "12:00"));
    }

    @Test
    public void testMarshaller() {
        sessionXMLUtils.marshaller(sessionDtos);
        File xmlFile = new File(SessionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        sessionXMLUtils.marshaller(sessionDtos);
        List<SessionDto> unmarshalledDtos = sessionXMLUtils.unmarshaller();
        assertEquals(sessionDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < sessionDtos.size(); i++) {
            assertTrue(sessionDtos.get(i).equals(unmarshalledDtos.get(i)));
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
