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
    private CategorieEvenementXMLUtils categorieEvenementXMLUtils;
    private List<CategorieEvenementDto> categorieEvenementDtos;

    @BeforeEach
    public void setUp() {
        categorieEvenementXMLUtils = new CategorieEvenementXMLUtils();
        categorieEvenementDtos = new ArrayList<>();
        categorieEvenementDtos.add(new CategorieEvenementDto(1, "Nom1", "Description1"));
        categorieEvenementDtos.add(new CategorieEvenementDto(2, "Nom2", "Description2"));
    }

    @Test
    public void testMarshaller() {
        categorieEvenementXMLUtils.marshaller(categorieEvenementDtos);
        File xmlFile = new File(CategorieEvenementXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        categorieEvenementXMLUtils.marshaller(categorieEvenementDtos);
        List<CategorieEvenementDto> unmarshalledDtos = categorieEvenementXMLUtils.unmarshaller();
        assertEquals(categorieEvenementDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(categorieEvenementDtos.get(0).getDescriptionCategorieEvenement(), unmarshalledDtos.get(0).getDescriptionCategorieEvenement(), "The description should match");
        assertEquals(categorieEvenementDtos.get(0).getNomCategorieEvenement(), unmarshalledDtos.get(0).getNomCategorieEvenement(), "The name should match");
        assertEquals(categorieEvenementDtos.get(0).getIdCategorieEvenement(), unmarshalledDtos.get(0).getIdCategorieEvenement(), "The ID should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
