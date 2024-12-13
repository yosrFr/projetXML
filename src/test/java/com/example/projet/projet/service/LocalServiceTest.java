package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.LocalDto;
import com.example.projet.projet.modele.XMLUtils.LocalXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class LocalServiceTest {
    private LocalService localService;
    private LocalXMLUtils localXMLUtils;
    private List<LocalDto> localDtos;

    @BeforeEach
    public void setUp() {
        localXMLUtils = new LocalXMLUtils();
        localService = new LocalService(localXMLUtils);
        localDtos = new ArrayList<>();
        localDtos.add(new LocalDto("adresseLocal1", 20, 1, "nomLocal1", "numTelLocal1"));
        localDtos.add(new LocalDto("adresseLocal2", 30, 2, "nomLocal2", "numTelLocal2"));
        localXMLUtils.marshaller(localDtos);
    }

    @Test
    public void testGetAllNomsLocals() {
        List<String> result = localService.getAllNomsLocals();
        List<String> nomsLocals = localDtos.stream().map(LocalDto::getNomLocal).collect(Collectors.toList());
        assertEquals(nomsLocals, result, "Le noms des locaux ne sont pas identiques");
    }

    @Test
    public void testGetAllLocals() {
        List<LocalDto> result = localService.getAllLocals();
        assertEquals(localDtos.size(), result.size());
    }

    @Test
    public void testGetLocalById() {
        for (int i = 0; i < localDtos.size(); i++) {
            LocalDto result = localService.getLocalById(localDtos.get(i).getIdLocal());
            assertNotNull(result, "Le local doit exister");
            assertEquals(localDtos.get(i).getIdLocal(), result.getIdLocal(), "L'ID doit etre la meme");
            assertEquals(localDtos.get(i).getCapaciteLocal(), result.getCapaciteLocal(), "La capacité doit etre la meme");
            assertEquals(localDtos.get(i).getAdresseLocal(), result.getAdresseLocal(), "L'adresse doit etre la meme");
            assertEquals(localDtos.get(i).getNomLocal(), result.getNomLocal(), "Le nom doit etre le meme");
            assertEquals(localDtos.get(i).getNumTelLocal(), result.getNumTelLocal(), "Le numero de telephone doit etre le meme");
        }
    }

    @Test
    public void testAjouterLocal() {
        LocalDto newLocal = new LocalDto("adresseLocal3", 20, 3, "nomLocal3", "numTelLocal3");
        localService.ajouterLocal(newLocal);
        List<LocalDto> result = localService.getAllLocals();
        assertEquals(localDtos.size() + 1, result.size(), "Le nombre de locaux doit augmenter");
    }

    @Test
    public void testModifierLocal() {
        LocalDto updatedLocal = new LocalDto("adresseLocal2_updated", 20, 2, "nomLocal2", "numTelLocal2");
        localService.modifierLocal(updatedLocal);
        LocalDto result = localService.getLocalById(2);
        assertNotNull(result, "Le local doit exister");
        assertEquals("adresseLocal2_updated", result.getAdresseLocal(), "L'adresse doit etre la meme");
    }

    @Test
    public void testSupprimerLocal() {
        localService.supprimerLocal(1);
        List<LocalDto> result = localService.getAllLocals();
        assertEquals(localDtos.size() - 1, result.size(), "Le nombre de locaux doit diminuer");
        assertNull(localService.getLocalById(1), "Le local supprimé ne doit pas exister");
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(LocalXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }

 */
}
