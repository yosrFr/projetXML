package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.EvenementDto;
import com.example.projet.projet.modele.Dto.InscriptionDto;
import com.example.projet.projet.modele.Dto.ParticipantDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscriptionXMLUtilsTest {
    private InscriptionXMLUtils inscriptionXMLUtils;
    private List<InscriptionDto> inscriptionDtos;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        inscriptionXMLUtils = new InscriptionXMLUtils();
        inscriptionDtos = new ArrayList<>();
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45"));
        sessionDtos.add(new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45"));
        EvenementDto evenement = new EvenementDto(1, "titreEvenement1", "descriptionEvenement1", "dateDebutEvenement1", "dateFinEvenement1", 20, 50, sessionDtos);
        ParticipantDto participant1 = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1);
        ParticipantDto participant2 = new ParticipantDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2);
        inscriptionDtos.add(new InscriptionDto(new Date(), 1,  null,  null, participant1,  evenement));
        inscriptionDtos.add(new InscriptionDto(new Date(), 2,  null,  null, participant2,  evenement));
    }

    @Test
    public void testMarshaller(){
        inscriptionXMLUtils.marshaller(inscriptionDtos);
        File xmlFile = new File(InscriptionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller(){
        inscriptionXMLUtils.marshaller(inscriptionDtos);
        List<InscriptionDto> unmarshalledDtos = inscriptionXMLUtils.unmarshaller();
        assertEquals(inscriptionDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < inscriptionDtos.size(); i++){
            assertEquals(inscriptionDtos.get(i).getDateInscription(), unmarshalledDtos.get(i).getDateInscription(), "La date d'inscription doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getIdInscription(), unmarshalledDtos.get(i).getIdInscription(), "L'ID de l'inscription doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getPresence(), unmarshalledDtos.get(i).getPresence(), "La presence doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getRetour(), unmarshalledDtos.get(i).getRetour(), "Le retour etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getNom(), unmarshalledDtos.get(i).getParticipant().getNom(), "Le nom doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getPrenom(), unmarshalledDtos.get(i).getParticipant().getPrenom(), "Le prenom doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getAdresse(), unmarshalledDtos.get(i).getParticipant().getAdresse(), "L'adresse doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getEmail(), unmarshalledDtos.get(i).getParticipant().getEmail(), "L'emain doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getTelephone(), unmarshalledDtos.get(i).getParticipant().getTelephone(), "Le numero de telephone doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getDateNaissance(), unmarshalledDtos.get(i).getParticipant().getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getSexe(), unmarshalledDtos.get(i).getParticipant().getSexe(), "Le sexe doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getParticipant().getIdParticipant(), unmarshalledDtos.get(i).getParticipant().getIdParticipant(), "L'ID du participant doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getIdEvenement(), unmarshalledDtos.get(i).getEvenement().getIdEvenement(), "L'ID de l'evenement doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getTitreEvenement(), unmarshalledDtos.get(i).getEvenement().getTitreEvenement(), "Le titre de l'evenement doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getDescriptionEvenement(), unmarshalledDtos.get(i).getEvenement().getDescriptionEvenement(), "La description doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getDateDebutEvenement(), unmarshalledDtos.get(i).getEvenement().getDateDebutEvenement(), "La date de debut doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getDateFinEvenement(), unmarshalledDtos.get(i).getEvenement().getDateFinEvenement(), "La date de fin doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getNombreParticipantsMaximal(), unmarshalledDtos.get(i).getEvenement().getNombreParticipantsMaximal(), "Le nombre de participants maximal doit etre la meme");
            assertEquals(inscriptionDtos.get(i).getEvenement().getNombreParticipantsEstime(), unmarshalledDtos.get(i).getEvenement().getNombreParticipantsEstime(), "Le nombre de participants estime doit etre la meme");
            for(int j = 0; j < sessionDtos.size(); j++) {
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getIdSession(), unmarshalledDtos.get(i).getEvenement().getSessions().get(j).getIdSession(), "L'ID de la session doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getTitreSession(), unmarshalledDtos.get(i).getEvenement().getSessions().get(j).getTitreSession(), "Le titre de la session doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getDateSession(), unmarshalledDtos.get(i).getEvenement().getSessions().get(j).getDateSession(), "La date de la session doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getHeureDebutSession(), unmarshalledDtos.get(i).getEvenement().getSessions().get(j).getHeureDebutSession(), "L'heure de debut doit etre la meme");
                assertEquals(inscriptionDtos.get(i).getEvenement().getSessions().get(j).getHeureFinSession(), unmarshalledDtos.get(i).getEvenement().getSessions().get(j).getHeureFinSession(), "L'heure de fin doit etre la meme");
            }
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(InscriptionXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
