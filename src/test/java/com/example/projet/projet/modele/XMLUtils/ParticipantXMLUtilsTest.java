package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParticipantXMLUtilsTest {
    private final ParticipantXMLUtils participantXMLUtils = new ParticipantXMLUtils();
    private List<ParticipantDto> participantDtos;

    @BeforeEach
    public void setUp() {
        participantDtos = new ArrayList<>();
        participantDtos.add(new ParticipantDto("Doe", "John", "Sousse", "john.doe@example.com", "+21612345678", "2000-11-13", "homme", 1));
        participantDtos.add(new ParticipantDto("Smith", "Jane", "Sfax", "jane.smith@gmail.com", "+21687654321", "2000-11-01", "femme", 2));
    }

    @Test
    public void testMarshaller() {
        participantXMLUtils.marshaller(participantDtos);
        File xmlFile = new File(ParticipantXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        participantXMLUtils.marshaller(participantDtos);
        List<ParticipantDto> unmarshalledDtos = participantXMLUtils.unmarshaller();
        assertEquals(participantDtos.size(), unmarshalledDtos.size());
        for(int i = 0; i < participantDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(participantDtos.get(i)));
        }
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(ParticipantXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }*/
}
