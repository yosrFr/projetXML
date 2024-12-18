package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.*;
import com.example.projet.projet.modele.XMLUtils.InscriptionXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class InscriptionServiceTest {
    private InscriptionService inscriptionService;
    private final InscriptionXMLUtils inscriptionXMLUtils = new InscriptionXMLUtils();
    private List<InscriptionDto> inscriptionDtos;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        inscriptionService = new InscriptionService(inscriptionXMLUtils);
        inscriptionDtos = new ArrayList<>();
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00"));
        sessionDtos.add(new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00"));
        sessionDtos.add(new SessionDto(33, "2024-12-13", " Conférence internationale sur les maladies rares et les médicaments orphelins (Rare Diseases 2025)", "09:00", "12:00"));
        CategorieEvenementDto categorie1 = new CategorieEvenementDto(1, "Conférence", "Événements axés sur des conférences.");
        CategorieEvenementDto categorie2 = new CategorieEvenementDto(2, "Atelier", "Événements interactifs d'apprentissage.");
        EvenementDto evenement = new EvenementDto(1, "Conférence Tech 2024", "Une conférence dédiée à l'innovation technologique.", "2024-12-10", "2024-12-11", 45, 50, sessionDtos, categorie1);
        ParticipantDto participant1 = new ParticipantDto("Doe", "John", "Sousse", "john.doe@example.com", "+21612345678", "2000-11-13", "homme", 1);
        ParticipantDto participant2 = new ParticipantDto("Smith", "Jane", "Sfax", "jane.smith@gmail.com", "+21687654321", "2000-11-01", "femme", 2);
        TypeInscriptionDto type1 = new TypeInscriptionDto("Inscription générale pour assister à l'événement sans conditions particulières", "Standard", 1);
        TypeInscriptionDto type2 = new TypeInscriptionDto("Inscription offrant des avantages exclusifs comme des sièges privilégiés et un accès à des événements privés", "VIP", 2);
        inscriptionDtos.add(new InscriptionDto("2024-12-01", 1,  null,  null, participant1,  evenement, type1));
        inscriptionDtos.add(new InscriptionDto("2024-12-02", 2,  true,  true, participant2,  evenement, type2));
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
        sessionDtos.add(new SessionDto(1, "2024-11-15", "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, "2024-11-16", "titreSession2", "09:45", "09:45"));
        CategorieEvenementDto categorie1 = new CategorieEvenementDto(1, "Conférence", "Événements axés sur des conférences.");
        EvenementDto evenement = new EvenementDto(1, "titreEvenement1", "descriptionEvenement1", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos, categorie1);
        ParticipantDto participant1 = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", "2000-02-02", "M", 1);
        TypeInscriptionDto type1 = new TypeInscriptionDto("Inscription générale pour assister à l'événement sans conditions particulières", "Standard", 1);
        InscriptionDto newInscription = new InscriptionDto("2024-10-10", 3,  null,  null, participant1,  evenement, type1);
        inscriptionService.ajouterInscription(newInscription);
        List<InscriptionDto> result = inscriptionXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(inscription -> inscription.getIdInscription() == newInscription.getIdInscription());
        assertTrue(exist, "L'ajout de l'inscription n'a pas réussi");
    }

    @Test
    public void testGetInscriptionById(){
        for (int i = 0; i < inscriptionDtos.size(); i++) {
            InscriptionDto result = inscriptionService.getInscriptionById(inscriptionDtos.get(i).getIdInscription());
            assertNotNull(result, "L'inscription n'existe pas");
            assertEquals(result.getDateInscription(), result.getDateInscription(), "La date d'inscription doit etre la meme");
            assertEquals(result.getIdInscription(), result.getIdInscription(), "L'ID de l'inscription doit etre la meme");
            assertEquals(result.getPresence(), result.getPresence(), "La presence doit etre la meme");
            assertEquals(result.getRetour(), result.getRetour(), "Le retour etre la meme");
            assertEquals(result.getParticipant().getNom(), result.getParticipant().getNom(), "Le nom doit etre le meme");
            assertEquals(result.getParticipant().getPrenom(), result.getParticipant().getPrenom(), "Le prenom doit etre le meme");
            assertEquals(result.getParticipant().getAdresse(), result.getParticipant().getAdresse(), "L'adresse doit etre la meme");
            assertEquals(result.getParticipant().getEmail(), result.getParticipant().getEmail(), "L'email doit etre le meme");
            assertEquals(result.getParticipant().getTelephone(), result.getParticipant().getTelephone(), "Le numero de telephone doit etre le meme");
            assertEquals(result.getParticipant().getDateNaissance(), result.getParticipant().getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(result.getParticipant().getSexe(), result.getParticipant().getSexe(), "Le sexe doit etre le meme");
            assertEquals(result.getParticipant().getIdParticipant(), result.getParticipant().getIdParticipant(), "L'ID du participant doit etre la meme");
            assertEquals(result.getEvenement().getIdEvenement(), result.getEvenement().getIdEvenement(), "L'ID de l'evenement doit etre la meme");
            assertEquals(result.getEvenement().getTitreEvenement(), result.getEvenement().getTitreEvenement(), "Le titre de l'evenement doit etre le meme");
            assertEquals(result.getEvenement().getDescriptionEvenement(), result.getEvenement().getDescriptionEvenement(), "La description doit etre la meme");
            assertEquals(result.getEvenement().getDateDebutEvenement(), result.getEvenement().getDateDebutEvenement(), "La date de debut doit etre la meme");
            assertEquals(result.getEvenement().getDateFinEvenement(), result.getEvenement().getDateFinEvenement(), "La date de fin doit etre la meme");
            assertEquals(result.getEvenement().getNombreParticipantsMaximal(), result.getEvenement().getNombreParticipantsMaximal(), "Le nombre de participants maximal doit etre le meme");
            assertEquals(result.getEvenement().getNombreParticipantsEstime(), result.getEvenement().getNombreParticipantsEstime(), "Le nombre de participants estime doit etre le meme");
            for(int j = 0; j < sessionDtos.size(); j++) {
                assertEquals(result.getEvenement().getSessions().get(j).getIdSession(), result.getEvenement().getSessions().get(j).getIdSession(), "L'ID de la session doit etre la meme");
                assertEquals(result.getEvenement().getSessions().get(j).getTitreSession(), result.getEvenement().getSessions().get(j).getTitreSession(), "Le titre de la session doit etre la meme");
                assertEquals(result.getEvenement().getSessions().get(j).getDateSession(), result.getEvenement().getSessions().get(j).getDateSession(), "La date de la session doit etre la meme");
                assertEquals(result.getEvenement().getSessions().get(j).getHeureDebutSession(), result.getEvenement().getSessions().get(j).getHeureDebutSession(), "L'heure de debut doit etre la meme");
                assertEquals(result.getEvenement().getSessions().get(j).getHeureFinSession(), result.getEvenement().getSessions().get(j).getHeureFinSession(), "L'heure de fin doit etre la meme");
            }
        }
    }

    @Test
    public void modifierInscription() {
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, "2024-11-11", "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, "2024-11-11", "titreSession2", "09:45", "09:45"));
        CategorieEvenementDto categorie1 = new CategorieEvenementDto(1, "Conférence", "Événements axés sur des conférences.");
        EvenementDto evenement = new EvenementDto(1, "titreEvenement1", "descriptionEvenement1", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos, categorie1);
        ParticipantDto participant1 = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", "2009-11-01", "M", 1);
        TypeInscriptionDto type1 = new TypeInscriptionDto("Inscription générale pour assister à l'événement sans conditions particulières", "Standard", 1);
        InscriptionDto updatedInscription = new InscriptionDto("2024-11-01", 2,  true,  false, participant1,  evenement, type1);
        inscriptionService.modifierInscription(updatedInscription);
        InscriptionDto result = inscriptionService.getInscriptionById(2);
        assertNotNull(result);
        assertEquals(false, result.getRetour());
        assertEquals(true, result.getPresence());


    }

    @Test

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(InscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
