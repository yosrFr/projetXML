package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.CategorieEvenementDto;
import com.example.projet.projet.modele.Dto.EvenementDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenementXMLUtilsTest {
    private final  EvenementXMLUtils evenementXMLUtils = new EvenementXMLUtils();
    private List<EvenementDto> evenementDtos;
    private List<SessionDto> sessionDtos;

    @BeforeEach
    public void setUp() {
        evenementDtos = new ArrayList<>();
        sessionDtos = new ArrayList<>();
        sessionDtos.add(new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00"));
        sessionDtos.add(new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00"));
        sessionDtos.add(new SessionDto(33, "2024-12-13", " Conférence internationale sur les maladies rares et les médicaments orphelins (Rare Diseases 2025)", "09:00", "12:00"));
        CategorieEvenementDto categorie1 = new CategorieEvenementDto(1, "Conférence", "Événements axés sur des conférences.");
        CategorieEvenementDto categorie2 = new CategorieEvenementDto(2, "Atelier", "Événements interactifs d'apprentissage.");
        evenementDtos.add(new EvenementDto(1, "Conférence Tech 2024", "Une conférence dédiée à l'innovation technologique.", "2024-12-10", "2024-12-11", 45, 50, sessionDtos, categorie1));
        evenementDtos.add(new EvenementDto(2, "Conférence MED 2024", "Une conférence dédiée à l'innovation des médicaments.", "2024-12-13", "2024-12-13", 45, 50, sessionDtos, categorie2));
    }

    @Test
    void testMarshaller() {
        evenementXMLUtils.marshaller(evenementDtos);
        File xmlFile = new File(EvenementXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    void testUnmarshaller() {
        evenementXMLUtils.marshaller(evenementDtos);
        List<EvenementDto> unmarshalledDtos = evenementXMLUtils.unmarshaller();
        assertEquals(evenementDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < evenementDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(evenementDtos.get(i)));
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(EvenementXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
