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
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        participantXMLUtils.marshaller(participantDtos);
        List<ParticipantDto> unmarshalledDtos = participantXMLUtils.unmarshaller();
        assertEquals(participantDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for (int i = 0; i < participantDtos.size(); i++) {
            assertEquals(participantDtos.get(i).getNom(), unmarshalledDtos.get(i).getNom(), "Le nom doit etre la meme");
            assertEquals(participantDtos.get(i).getPrenom(), unmarshalledDtos.get(i).getPrenom(), "Le prenom doit etre la meme");
            assertEquals(participantDtos.get(i).getAdresse(), unmarshalledDtos.get(i).getAdresse(), "L'adresse doit etre la meme");
            assertEquals(participantDtos.get(i).getEmail(), unmarshalledDtos.get(i).getEmail(), "L'email doit etre la meme");
            assertEquals(participantDtos.get(i).getTelephone(), unmarshalledDtos.get(i).getTelephone(), "Le numero de telephone doit etre la meme");
            assertEquals(participantDtos.get(i).getDateNaissance(), unmarshalledDtos.get(i).getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(participantDtos.get(i).getSexe(), unmarshalledDtos.get(i).getSexe(), "Le sexe doit etre la meme");
            assertEquals(participantDtos.get(i).getIdParticipant(), unmarshalledDtos.get(i).getIdParticipant(), "L'ID doit etre la meme");
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(ParticipantXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
