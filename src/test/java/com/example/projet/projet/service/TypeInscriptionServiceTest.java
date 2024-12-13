package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.TypeInscriptionDto;
import com.example.projet.projet.modele.XMLUtils.TypeInscriptionXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TypeInscriptionServiceTest {
    private TypeInscriptionService typeInscriptionService;
    private TypeInscriptionXMLUtils typeInscriptionXMLUtils;
    private List<TypeInscriptionDto> typeInscriptionDtos;

    @BeforeEach
    public void setUp() {
        typeInscriptionXMLUtils = new TypeInscriptionXMLUtils();
        typeInscriptionService = new TypeInscriptionService(typeInscriptionXMLUtils);
        typeInscriptionDtos = new ArrayList<>();
        typeInscriptionDtos.add(new TypeInscriptionDto("Description1", "Nom1", 1));
        typeInscriptionDtos.add(new TypeInscriptionDto("Description2", "Nom2", 2));
        typeInscriptionXMLUtils.marshaller(typeInscriptionDtos);
    }

    @Test
    public void testGetAllTypesInscription() {
        List<TypeInscriptionDto> result = typeInscriptionService.getAllTypesInscription();
        assertEquals(typeInscriptionDtos.size(), result.size(), "Les tailles des listes doivent etre égales");
    }

    @Test
    public void testGetTypeInscriptionById() {
        for(int i =0 ; i < typeInscriptionDtos.size(); i++) {
            TypeInscriptionDto result = typeInscriptionService.getTypeInscriptionById(typeInscriptionDtos.get(i).getIdTypeInscription());
            assertNotNull(result, "Le type d'inscription doit exister");
            assertEquals(typeInscriptionDtos.get(i).getDescriptionTypeInscription(), result.getDescriptionTypeInscription(), "La description doit etre la meme");
            assertEquals(typeInscriptionDtos.get(i).getNomTypeInscription(), result.getNomTypeInscription(), "Le nom doit etre le meme");
            assertEquals(typeInscriptionDtos.get(i).getIdTypeInscription(), result.getIdTypeInscription(), "L'ID doit etre le meme");
        }
    }

    @Test
    public void testAjouterTypeInscription() {
        TypeInscriptionDto newTypeInscription = new TypeInscriptionDto("Description3", "Nom3", 3);
        typeInscriptionService.ajouterTypeInscription(newTypeInscription);
        List<TypeInscriptionDto> result = typeInscriptionService.getAllTypesInscription();
        assertEquals(typeInscriptionDtos.size() + 1, result.size(), "Le nombre de types d'inscriptions devrait augmenter");
    }

    @Test
    public void testSupprimerTypeInscription() {
        typeInscriptionService.supprimerTypeInscription(1);
        List<TypeInscriptionDto> result = typeInscriptionService.getAllTypesInscription();
        assertEquals(typeInscriptionDtos.size() - 1, result.size(), "Le nombre de type d'inscriptions devrait diminuer");
        assertNull(typeInscriptionService.getTypeInscriptionById(1), "Le type d'inscription supprimé ne doit pas exister");
    }

    @Test
    public void testModifierTypeInscription() {
        TypeInscriptionDto updatedTypeInscription = new TypeInscriptionDto("Description1_updated", "Nom1_updated", 1);
        typeInscriptionService.modifierTypeInscription(updatedTypeInscription);
        TypeInscriptionDto result = typeInscriptionService.getTypeInscriptionById(1);
        assertNotNull(result, "Le type d'inscription doit exister");
        assertEquals("Description1_updated", result.getDescriptionTypeInscription(), "La description doit etre la meme");
        assertEquals("Nom1_updated", result.getNomTypeInscription(), "Le nom doit etre le meme");
        assertEquals(1, result.getIdTypeInscription(), "L'ID doit etre le meme");
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }

 */
}
