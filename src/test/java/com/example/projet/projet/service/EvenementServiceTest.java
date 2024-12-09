package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.EvenementDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.EvenementXMLUtils;
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

public class EvenementServiceTest {
    private EvenementService evenementService;
    private EvenementXMLUtils evenementXMLUtils;
    private List<EvenementDto> evenementDtos;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        evenementXMLUtils = new EvenementXMLUtils();
        evenementService = new EvenementService(evenementXMLUtils);
        evenementDtos = new ArrayList<>();
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        evenementDtos.add(new EvenementDto(1, "titreEvenement1", "descriptionEvenement1", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos));
        evenementDtos.add(new EvenementDto(2, "titreEvenement2", "descriptionEvenement2", "dateDebutEvenement2", "dateFinEvenement2", 20, 50, sessionDtos));
        evenementXMLUtils.marshaller(evenementDtos);
    }

    @Test
    public void testGetAllEvenements() {
        List<EvenementDto> result = evenementService.getAllEvenements();
        assertEquals(evenementDtos.size(), result.size());
    }

    @Test
    public void testGetEvenementById() {
        for(int i = 0; i < evenementDtos.size(); i++){
            EvenementDto result = evenementService.getEvenementById(evenementDtos.get(i).getIdEvenement());
            assertNotNull(result, "L'evenement doit exister");
            assertEquals(evenementDtos.get(i).getIdEvenement(), result.getIdEvenement(), "L'ID de l'evenement doit etre le meme");
            assertEquals(evenementDtos.get(i).getTitreEvenement(), result.getTitreEvenement(), "Le titre doit etre le meme");
            assertEquals(evenementDtos.get(i).getDateFinEvenement(), result.getDateFinEvenement(), "La date de fin doit etre le meme");
            assertEquals(evenementDtos.get(i).getDescriptionEvenement(), result.getDescriptionEvenement(), "La description doit etre le meme");
            assertEquals(evenementDtos.get(i).getDateDebutEvenement(), result.getDateDebutEvenement(), "La date de debut doit etre le meme");
            assertEquals(evenementDtos.get(i).getNombreParticipantsMaximal(), result.getNombreParticipantsMaximal(), "Le nombre de participants maximal doit etre le meme");
            assertEquals(evenementDtos.get(i).getNombreParticipantsEstime(), result.getNombreParticipantsEstime(), "Le nombre de participants estimé doit etre le meme");
            for(int j = 0; j < sessionDtos.size(); j++) {
                assertEquals(evenementDtos.get(i).getSessions().get(j).getIdSession(), result.getSessions().get(j).getIdSession(), "L'ID de la session doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getTitreSession(), result.getSessions().get(j).getTitreSession(), "Le titre de la session doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getDateSession(), result.getSessions().get(j).getDateSession(), "La date de la session doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getHeureDebutSession(), result.getSessions().get(j).getHeureDebutSession(), "L'heure de debut doit etre la meme");
                assertEquals(evenementDtos.get(i).getSessions().get(j).getHeureFinSession(), result.getSessions().get(j).getHeureFinSession(), "L'heure de fin doit etre la meme");
            }
        }
    }

    @Test
    public void testAjouterEvenement() {
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        EvenementDto newEvenement = new EvenementDto(3, "titreEvenement3", "descriptionEvenement3", "dateDebutEvenement3", "dateFinEvenement3", 20, 50, sessionDtos);
        evenementService.ajouterEvenement(newEvenement);
        List<EvenementDto> result = evenementService.getAllEvenements();
        assertEquals(evenementDtos.size() + 1, result.size(), "Le nombre d'evenement doit augmenter");
    }

    @Test
    public void testModifierEvenement() {
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        EvenementDto updatedEvenement = new EvenementDto(1, "titreEvenement1_modifier", "descriptionEvenement1_modifier", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos);
        evenementService.modifierEvenement(updatedEvenement);
        EvenementDto result = evenementService.getEvenementById(1);
        assertNotNull(result, "L'evenement doit exister");
        assertEquals("titreEvenement1_modifier", result.getTitreEvenement(), "Le titre doit etre le meme");
    }

    @Test
    public void testSupprimerEvenement() {
        evenementService.supprimerEvenement(1);
        List<EvenementDto> result = evenementService.getAllEvenements();
        assertEquals(evenementDtos.size() - 1, result.size(), "Le nombre d'evenement doit diminuer");
        assertNull(evenementService.getEvenementById(1), "L'evenement supprimé ne doit pas exister");
    }

    @Test
    public void testGetAllSessionsEventOrderedByDate() {
        List<SessionDto> result = evenementService.getAllSessionsEventOrderedByDate(1);
        List<SessionDto> attendu =  evenementDtos.stream()
                .filter(evenement -> evenement.getIdEvenement() == 1)
                .flatMap(evenement -> evenement.getSessions()
                        .stream())
                .sorted(Comparator.comparing(SessionDto::getDateSession)
                        .thenComparing(SessionDto::getHeureDebutSession))
                .collect(Collectors.toList());
        for (int i = 0; i < attendu.size(); i++) {
            assertEquals(attendu.get(i).getIdSession(), result.get(i).getIdSession());
            assertEquals(attendu.get(i).getTitreSession(), result.get(i).getTitreSession());
            assertEquals(attendu.get(i).getDateSession(), result.get(i).getDateSession());
            assertEquals(attendu.get(i).getHeureDebutSession(), result.get(i).getHeureDebutSession());
            assertEquals(attendu.get(i).getHeureFinSession(), result.get(i).getHeureFinSession());
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(EvenementXMLUtils.XML_FILE);
        if(xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
