package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import com.example.projet.projet.modele.XMLUtils.ParticipantXMLUtils;
import com.example.projet.projet.modele.XMLUtils.TypeInscriptionXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipantServiceTest {
    private ParticipantService participantService;
    private ParticipantXMLUtils participantXMLUtils;
    private List<ParticipantDto> participantDtos;

    @BeforeEach
    public void setUp() {
        participantXMLUtils = new ParticipantXMLUtils();
        participantService = new ParticipantService(participantXMLUtils);
        participantDtos = new ArrayList<>();
        participantDtos.add(new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1));
        participantDtos.add(new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2));
        participantXMLUtils.marshaller(participantDtos);
    }

    @Test
    public void testAjouterParticipant(){
        ParticipantDto newParticipant = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 3);
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
