package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.CategorieEvenementDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategorieEvenementXMLUtilsTest {
    private final CategorieEvenementXMLUtils categorieEvenementXMLUtils = new CategorieEvenementXMLUtils();
    private List<CategorieEvenementDto> categorieEvenementDtos;

    @BeforeEach
    public void setUp() {
        categorieEvenementDtos = new ArrayList<>();
        categorieEvenementDtos.add(new CategorieEvenementDto(1, "Conférence", "Événements axés sur des conférences."));
        categorieEvenementDtos.add(new CategorieEvenementDto(2, "Atelier", "Événements interactifs d'apprentissage."));
    }

    @Test
    public void testMarshaller() {
        categorieEvenementXMLUtils.marshaller(categorieEvenementDtos);
        File xmlFile = new File(CategorieEvenementXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        categorieEvenementXMLUtils.marshaller(categorieEvenementDtos);
        List<CategorieEvenementDto> unmarshalledDtos = categorieEvenementXMLUtils.unmarshaller();
        assertEquals(categorieEvenementDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < categorieEvenementDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(categorieEvenementDtos.get(i)));
        }
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(CategorieEvenementXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }*/
}
