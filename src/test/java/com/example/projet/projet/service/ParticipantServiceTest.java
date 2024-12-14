package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import com.example.projet.projet.modele.XMLUtils.ParticipantXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipantServiceTest {
    private ParticipantService participantService;
    private final ParticipantXMLUtils participantXMLUtils = new ParticipantXMLUtils();
    private List<ParticipantDto> participantDtos;

    @BeforeEach
    public void setUp() {
        participantService = new ParticipantService(participantXMLUtils);
        participantDtos = new ArrayList<>();
        participantDtos.add(new ParticipantDto("Doe", "John", "Sousse", "john.doe@example.com", "+21612345678", "2000-11-13", "homme", 1));
        participantDtos.add(new ParticipantDto("Smith", "Jane", "Sfax", "jane.smith@gmail.com", "+21687654321", "2000-11-01", "femme", 2));
        participantXMLUtils.marshaller(participantDtos);
    }

    @Test
    public void testAjouterParticipant(){
        ParticipantDto newParticipant = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", "2001-02-03", "M", 3);
        participantService.ajouterParticipant(newParticipant);
        List<ParticipantDto> result = participantXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(participant -> participant.getIdParticipant() == newParticipant.getIdParticipant());
        assertTrue(exist, "L'ajout du participant n'a pas réussi");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(ParticipantXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
