package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParticipantXMLUtilsTest {
    private ParticipantXMLUtils participantXMLUtils;
    private List<ParticipantDto> participantDtos;

    @BeforeEach
    public void setUp() {
        participantXMLUtils = new ParticipantXMLUtils();
        participantDtos = new ArrayList<>();
        participantDtos.add(new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1));
        participantDtos.add(new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2));
    }

    @Test
    public void testMarshaller() {
        participantXMLUtils.marshaller(participantDtos);
        File xmlFile = new File(ParticipantXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        participantXMLUtils.marshaller(participantDtos);
        List<ParticipantDto> unmarshalledDtos = participantXMLUtils.unmarshaller();
        assertEquals(participantDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(participantDtos.get(0).getNom(), unmarshalledDtos.get(0).getNom(), "The nom should match");
        assertEquals(participantDtos.get(0).getPrenom(), unmarshalledDtos.get(0).getPrenom(), "The prenom should match");
        assertEquals(participantDtos.get(0).getAdresse(), unmarshalledDtos.get(0).getAdresse(), "The adress should match");
        assertEquals(participantDtos.get(0).getEmail(), unmarshalledDtos.get(0).getEmail(), "The email should match");
        assertEquals(participantDtos.get(0).getTelephone(), unmarshalledDtos.get(0).getTelephone(), "The tel should match");
        assertEquals(participantDtos.get(0).getDateNaissance(), unmarshalledDtos.get(0).getDateNaissance(), "The date should match");
        assertEquals(participantDtos.get(0).getSexe(), unmarshalledDtos.get(0).getSexe(), "The sexe should match");
        assertEquals(participantDtos.get(0).getIdParticipant(), unmarshalledDtos.get(0).getIdParticipant(), "The sexe should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(ParticipantXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
