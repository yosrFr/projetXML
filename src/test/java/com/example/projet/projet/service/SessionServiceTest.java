package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.SessionXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SessionServiceTest {
    private SessionService sessionService;
    private SessionXMLUtils sessionXMLUtils;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        sessionXMLUtils = new SessionXMLUtils();
        sessionService = new SessionService(sessionXMLUtils);
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        sessionXMLUtils.marshaller(sessionDtos);
    }

    @Test
    public void testGetSessionById() {
        for (int i = 0; i < sessionDtos.size(); i++) {
            SessionDto result = sessionService.getSessionById(sessionDtos.get(i).getIdSession());
            assertNotNull(result);
            assertEquals(sessionDtos.get(i).getIdSession(), result.getIdSession());
            assertEquals(sessionDtos.get(i).getTitreSession(), result.getTitreSession());
            assertEquals(sessionDtos.get(i).getDateSession(), result.getDateSession());
        }
    }

    @Test
    public void testAjouterSession() {
        SessionDto newSession = new SessionDto(3, new Date(), "titreSession1", "09:45", "09:45");
        sessionService.ajouterSession(newSession);
        List<SessionDto> result = sessionXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(s -> s.getIdSession() == newSession.getIdSession());
        assertTrue(exist);
    }

    @Test
    public void testModifierSession() {
        SessionDto updatedSession = new SessionDto(2, new Date(), "titre", "09:45", "09:45");
        sessionService.modifierSession(updatedSession);
        SessionDto result = sessionService.getSessionById(2);
        assertNotNull(result);
        assertEquals("titre", result.getTitreSession());
        assertEquals(2, result.getIdSession());
    }

    @Test
    public void testSupprimerSession() {
        sessionService.supprimerSession(1);
        List<SessionDto> result = sessionXMLUtils.unmarshaller();
        assertEquals(sessionDtos.size() - 1, result.size());
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File (SessionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
