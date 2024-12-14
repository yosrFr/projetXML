package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.MaterielDto;
import com.example.projet.projet.modele.XMLUtils.MaterielXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MaterielServiceTest {
    private MaterielService materielService;
    private MaterielXMLUtils materielXMLUtils = new MaterielXMLUtils();
    private List<MaterielDto> materielDtos;

    @BeforeEach
    public void setUp() {
        materielService = new MaterielService(materielXMLUtils);
        materielDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(101, "datashow", "BenQ", "BenQ W1800i", "2022-12-12"));
        materielDtos.add(new MaterielDto(102, "TV", "LG", "OLED55B4PUA", "2022-12-23"));
        materielXMLUtils.marshaller(materielDtos);
    }

    @Test
    public void testGetAllNomsMaterielsDispo() {}

    @Test
    public void testGetAllMateriels() {
        List<MaterielDto> result = materielService.getAllMateriels();
        assertEquals(materielDtos.size(), result.size());
    }

    @Test
    public void testGetMaterielById() {
        for (int i = 0; i < materielDtos.size(); i++) {
            MaterielDto result = materielService.getMaterielById(materielDtos.get(i).getIdMateriel());
            assertNotNull(result);
            assertEquals(materielDtos.get(i).getIdMateriel(), result.getIdMateriel());
            assertEquals(materielDtos.get(i).getNomMateriel(), result.getNomMateriel());
            assertEquals(materielDtos.get(i).getMarqueMateriel(), result.getMarqueMateriel());
            assertEquals(materielDtos.get(i).getModeleMateriel(), result.getModeleMateriel());
            assertEquals(materielDtos.get(i).getDateAchatMateriel(), result.getDateAchatMateriel());
        }
    }

    @Test
    public void testAjouterMateriel() {
        MaterielDto newMateriel = new MaterielDto(3, "nom3", "marque3", "modele3", "2024-10-10");
        materielService.ajouterMateriel(newMateriel);
        List<MaterielDto> result = materielService.getAllMateriels();
        assertEquals(materielDtos.size() + 1, result.size());
    }

    @Test
    public void testModifierMateriel() {
        MaterielDto updatedMateriel = new MaterielDto(2, "nom2", "marque1", "modele2", "2022-10-12");
        materielService.modifierMateriel(updatedMateriel);
        MaterielDto result = materielService.getMaterielById(2);
        assertNotNull(result);
        assertEquals("marque1", result.getMarqueMateriel());
        assertEquals(2, result.getIdMateriel());
    }

    @Test
    public void testSupprimerMateriel() {
        materielService.supprimerMateriel(101);
        List<MaterielDto> result = materielService.getAllMateriels();
        assertEquals(materielDtos.size() - 1, result.size());
        assertNull(materielService.getMaterielById(101));
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(MaterielXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
