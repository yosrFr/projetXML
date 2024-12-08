package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.CategorieEvenementDto;
import com.example.projet.projet.modele.XMLUtils.CategorieEvenementXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategorieEvenementServiceTest {
    private CategorieEvenementService categorieEvenementService;
    private CategorieEvenementXMLUtils categorieEvenementXMLUtils;
    private List<CategorieEvenementDto> categorieEvenementDtos;

    @BeforeEach
    public void setUp() {
        categorieEvenementXMLUtils = new CategorieEvenementXMLUtils();
        categorieEvenementService = new CategorieEvenementService(categorieEvenementXMLUtils);
        categorieEvenementDtos = new ArrayList<>();
        categorieEvenementDtos.add(new CategorieEvenementDto(1, "Nom1", "Description1"));
        categorieEvenementDtos.add(new CategorieEvenementDto(2, "Nom2", "Description2"));
        categorieEvenementXMLUtils.marshaller(categorieEvenementDtos);
    }

    @Test
    public void testGetAllCategorieEvenement() {
        List<CategorieEvenementDto> result = categorieEvenementService.getAllCategoriesEvenement();
        assertEquals(categorieEvenementDtos.size(), result.size());
    }

    @Test
    public void testGetCategorieEvenementById() {
        for(int i = 0; i < categorieEvenementDtos.size(); i++){
            CategorieEvenementDto result = categorieEvenementService.getCategorieEvenementById(categorieEvenementDtos.get(i).getIdCategorieEvenement());
            assertNotNull(result, "La categorie d'evenement doit exister");
            assertEquals(categorieEvenementDtos.get(i).getIdCategorieEvenement(), result.getIdCategorieEvenement(), "L'ID doit etre la meme");
            assertEquals(categorieEvenementDtos.get(i).getNomCategorieEvenement(), result.getNomCategorieEvenement(), "Le nom doit etre la meme");
            assertEquals(categorieEvenementDtos.get(i).getDescriptionCategorieEvenement(), result.getDescriptionCategorieEvenement(), "La description doit etre la meme");
        }
    }

    @Test
    public void testAjouterCategorieEvenement() {
        CategorieEvenementDto newCategorie = new CategorieEvenementDto(3, "Nom3", "Description3");
        categorieEvenementService.ajouterCategorieEvenement(newCategorie);
        List<CategorieEvenementDto> result = categorieEvenementService.getAllCategoriesEvenement();
        assertEquals(categorieEvenementDtos.size() + 1, result.size(), "Le nombre de categorie d'evenement doit augmenter");
    }

    @Test
    public void testSupprimerCategorieEvenement() {
        categorieEvenementService.supprimerCategorieEvenement(1);
        List<CategorieEvenementDto> result = categorieEvenementService.getAllCategoriesEvenement();
        assertEquals(categorieEvenementDtos.size() - 1, result.size(), "Le nmbre de categorie d'evenement doit diminuer");
        assertNull(categorieEvenementService.getCategorieEvenementById(1), "La categorie d'evenement supprimée ne doit pas exister");
    }

    @Test
    public void testModifierCategorieEvenement() {
        CategorieEvenementDto updatedCategorie = new CategorieEvenementDto(1, "Nom1_updated", "Description1_updated");
        categorieEvenementService.modifierCategorieEvenement(updatedCategorie);
        CategorieEvenementDto result = categorieEvenementService.getCategorieEvenementById(1);
        assertNotNull(result, "La categorie d'evenement doit exister");
        assertEquals("Description1_updated", result.getDescriptionCategorieEvenement(), "La description doit etre la meme");
        assertEquals("Nom1_updated", result.getNomCategorieEvenement(), "Le nom doit etre le meme");
        assertEquals(1, result.getIdCategorieEvenement(), "L'ID doit etre le meme");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(CategorieEvenementXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
