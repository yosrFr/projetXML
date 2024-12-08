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
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        categorieEvenementXMLUtils.marshaller(categorieEvenementDtos);
        List<CategorieEvenementDto> unmarshalledDtos = categorieEvenementXMLUtils.unmarshaller();
        assertEquals(categorieEvenementDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for (int i = 0; i < unmarshalledDtos.size(); i++) {
            assertEquals(categorieEvenementDtos.get(i).getDescriptionCategorieEvenement(), unmarshalledDtos.get(i).getDescriptionCategorieEvenement(), "La description doit etre la meme");
            assertEquals(categorieEvenementDtos.get(i).getNomCategorieEvenement(), unmarshalledDtos.get(i).getNomCategorieEvenement(), "Le nom doit etre le meme");
            assertEquals(categorieEvenementDtos.get(i).getIdCategorieEvenement(), unmarshalledDtos.get(i).getIdCategorieEvenement(), "L'ID doit etre la meme");
        }
    }
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(CategorieEvenementXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
