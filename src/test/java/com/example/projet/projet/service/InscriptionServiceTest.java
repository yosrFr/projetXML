package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.EvenementDto;
import com.example.projet.projet.modele.Dto.InscriptionDto;
import com.example.projet.projet.modele.Dto.ParticipantDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.InscriptionXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class InscriptionServiceTest {
    private InscriptionService inscriptionService;
    private InscriptionXMLUtils inscriptionXMLUtils;
    private List<InscriptionDto> inscriptionDtos;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        inscriptionXMLUtils = new InscriptionXMLUtils();
        inscriptionService = new InscriptionService(inscriptionXMLUtils);
        inscriptionDtos = new ArrayList<>();
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        EvenementDto evenement = new EvenementDto(1, "titreEvenement1", "descriptionEvenement1", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos);
        ParticipantDto participant1 = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1);
        ParticipantDto participant2 = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2);
        inscriptionDtos.add(new InscriptionDto(new Date(), 1,  null,  null, participant1,  evenement));
        inscriptionDtos.add(new InscriptionDto(new Date(), 2,  null,  null, participant2,  evenement));
        inscriptionXMLUtils.marshaller(inscriptionDtos);
    }

    @Test
    public void testGetAllInscriptionsByEvenenemnt() {
        for (int i = 0; i < inscriptionDtos.size(); i++) {
            List<InscriptionDto> result = inscriptionService.getAllInscriptionsByEvenenemnt(inscriptionDtos.get(i).getEvenement().getIdEvenement());
            assertNotNull(result);
            assertEquals(inscriptionDtos.get(i).getDateInscription(), result.get(i).getDateInscription(), "La date d'inscription doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getIdInscription(), result.get(i).getIdInscription(), "L'ID de l'inscription doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getPresence(), result.get(i).getPresence(), "La presence doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getRetour(), result.get(i).getRetour(), "Le retour etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getNom(), result.get(i).getParticipant().getNom(), "Le nom doit etre le meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getPrenom(), result.get(i).getParticipant().getPrenom(), "Le prenom doit etre le meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getAdresse(), result.get(i).getParticipant().getAdresse(), "L'adresse doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getEmail(), result.get(i).getParticipant().getEmail(), "L'email doit etre le meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getTelephone(), result.get(i).getParticipant().getTelephone(), "Le numero de telephone doit etre le meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getDateNaissance(), result.get(i).getParticipant().getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getSexe(), result.get(i).getParticipant().getSexe(), "Le sexe doit etre le meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getIdParticipant(), result.get(i).getParticipant().getIdParticipant(), "L'ID du participant doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getIdEvenement(), result.get(i).getEvenement().getIdEvenement(), "L'ID de l'evenement doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getTitreEvenement(), result.get(i).getEvenement().getTitreEvenement(), "Le titre de l'evenement doit etre le meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getDescriptionEvenement(), result.get(i).getEvenement().getDescriptionEvenement(), "La description doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getDateDebutEvenement(), result.get(i).getEvenement().getDateDebutEvenement(), "La date de debut doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getDateFinEvenement(), result.get(i).getEvenement().getDateFinEvenement(), "La date de fin doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getNombreParticipantsMaximal(), result.get(i).getEvenement().getNombreParticipantsMaximal(), "Le nombre de participants maximal doit etre le meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getNombreParticipantsEstime(), result.get(i).getEvenement().getNombreParticipantsEstime(), "Le nombre de participants estime doit etre le meme");
            for(int j = 0; j < sessionDtos.size(); j++) {
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getIdSession(), result.get(i).getEvenement().getSessions().get(j).getIdSession(), "L'ID de la session doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getTitreSession(), result.get(i).getEvenement().getSessions().get(j).getTitreSession(), "Le titre de la session doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getDateSession(), result.get(i).getEvenement().getSessions().get(j).getDateSession(), "La date de la session doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getHeureDebutSession(), result.get(i).getEvenement().getSessions().get(j).getHeureDebutSession(), "L'heure de debut doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getHeureFinSession(), result.get(i).getEvenement().getSessions().get(j).getHeureFinSession(), "L'heure de fin doit etre la meme");
            }
        }
    }

    @Test
    public void testGetAllInscriptionsByEvenementOrderdByDate() {
        List<InscriptionDto> result = inscriptionService.getAllInscriptionsByEvenementOrderdByDate(1);
        List<InscriptionDto> attendu = inscriptionDtos.stream()
                .filter(inscription -> inscription.getEvenement().getIdEvenement() == 1)
                .sorted(Comparator.comparing(InscriptionDto::getDateInscription))
                .collect(Collectors.toList());
        assertEquals(result.size(), attendu.size());
        for (int i = 0; i < attendu.size(); i++) {
            assertEquals(attendu.get(i).getDateInscription(), result.get(i).getDateInscription(), "La date d'inscription doit etre la meme");
            assertEquals(attendu.get(i).getIdInscription(), result.get(i).getIdInscription(), "L'ID de l'inscription doit etre la meme");
            assertEquals(attendu.get(i).getPresence(), result.get(i).getPresence(), "La presence doit etre la meme");
            assertEquals(attendu.get(i).getRetour(), result.get(i).getRetour(), "Le retour etre la meme");
            assertEquals(attendu.get(i).getParticipant().getNom(), result.get(i).getParticipant().getNom(), "Le nom doit etre le meme");
            assertEquals(attendu.get(i).getParticipant().getPrenom(), result.get(i).getParticipant().getPrenom(), "Le prenom doit etre le meme");
            assertEquals(attendu.get(i).getParticipant().getAdresse(), result.get(i).getParticipant().getAdresse(), "L'adresse doit etre la meme");
            assertEquals(attendu.get(i).getParticipant().getEmail(), result.get(i).getParticipant().getEmail(), "L'email doit etre le meme");
            assertEquals(attendu.get(i).getParticipant().getTelephone(), result.get(i).getParticipant().getTelephone(), "Le numero de telephone doit etre le meme");
            assertEquals(attendu.get(i).getParticipant().getDateNaissance(), result.get(i).getParticipant().getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(attendu.get(i).getParticipant().getSexe(), result.get(i).getParticipant().getSexe(), "Le sexe doit etre le meme");
            assertEquals(attendu.get(i).getParticipant().getIdParticipant(), result.get(i).getParticipant().getIdParticipant(), "L'ID du participant doit etre la meme");
            assertEquals(attendu.get(i).getEvenement().getIdEvenement(), result.get(i).getEvenement().getIdEvenement(), "L'ID de l'evenement doit etre la meme");
            assertEquals(attendu.get(i).getEvenement().getTitreEvenement(), result.get(i).getEvenement().getTitreEvenement(), "Le titre de l'evenement doit etre le meme");
            assertEquals(attendu.get(i).getEvenement().getDescriptionEvenement(), result.get(i).getEvenement().getDescriptionEvenement(), "La description doit etre la meme");
            assertEquals(attendu.get(i).getEvenement().getDateDebutEvenement(), result.get(i).getEvenement().getDateDebutEvenement(), "La date de debut doit etre la meme");
            assertEquals(attendu.get(i).getEvenement().getDateFinEvenement(), result.get(i).getEvenement().getDateFinEvenement(), "La date de fin doit etre la meme");
            assertEquals(attendu.get(i).getEvenement().getNombreParticipantsMaximal(), result.get(i).getEvenement().getNombreParticipantsMaximal(), "Le nombre de participants maximal doit etre le meme");
            assertEquals(attendu.get(i).getEvenement().getNombreParticipantsEstime(), result.get(i).getEvenement().getNombreParticipantsEstime(), "Le nombre de participants estime doit etre le meme");
            for(int j = 0; j < sessionDtos.size(); j++) {
                assertEquals(attendu.get(i).getEvenement().getSessions().get(j).getIdSession(), result.get(i).getEvenement().getSessions().get(j).getIdSession(), "L'ID de la session doit etre la meme");
                assertEquals(attendu.get(i).getEvenement().getSessions().get(j).getTitreSession(), result.get(i).getEvenement().getSessions().get(j).getTitreSession(), "Le titre de la session doit etre la meme");
                assertEquals(attendu.get(i).getEvenement().getSessions().get(j).getDateSession(), result.get(i).getEvenement().getSessions().get(j).getDateSession(), "La date de la session doit etre la meme");
                assertEquals(attendu.get(i).getEvenement().getSessions().get(j).getHeureDebutSession(), result.get(i).getEvenement().getSessions().get(j).getHeureDebutSession(), "L'heure de debut doit etre la meme");
                assertEquals(attendu.get(i).getEvenement().getSessions().get(j).getHeureFinSession(), result.get(i).getEvenement().getSessions().get(j).getHeureFinSession(), "L'heure de fin doit etre la meme");
            }
        }
    }

    @Test
    public void testAjouterInscription() {
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        EvenementDto evenement = new EvenementDto(1, "titreEvenement1", "descriptionEvenement1", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos);
        ParticipantDto participant1 = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1);
        InscriptionDto newInscription = new InscriptionDto(new Date(), 3,  null,  null, participant1,  evenement);
        inscriptionService.ajouterInscription(newInscription);
        List<InscriptionDto> result = inscriptionXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(inscription -> inscription.getIdInscription() == newInscription.getIdInscription());
        assertTrue(exist, "L'ajout de l'inscription n'a pas réussi");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(InscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
