package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.*;
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
    private final InscriptionXMLUtils inscriptionXMLUtils = new InscriptionXMLUtils();
    private List<InscriptionDto> inscriptionDtos;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
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
    }

    @Test
    public void testMarshaller(){
        inscriptionXMLUtils.marshaller(inscriptionDtos);
        File xmlFile = new File(InscriptionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller(){
        inscriptionXMLUtils.marshaller(inscriptionDtos);
        List<InscriptionDto> unmarshalledDtos = inscriptionXMLUtils.unmarshaller();
        assertEquals(inscriptionDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < inscriptionDtos.size(); i++){
            assertTrue(unmarshalledDtos.get(i).equals(inscriptionDtos.get(i)));
        }
    }
/*
    @AfterEach
    void tearDown() {
        File file = new File(InscriptionXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

 */
}
