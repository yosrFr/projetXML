package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.MaterielDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaterielXMLUtilsTest {
    private MaterielXMLUtils materielXMLUtils;
    private List<MaterielDto> materielDtos;

    @BeforeEach
    public void setUp() {
        materielXMLUtils = new MaterielXMLUtils();
        materielDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(1, "nom1", "marque1", "modele1", new Date()));
        materielDtos.add(new MaterielDto(2, "nom2", "marque2", "modele2", new Date()));
    }

    @Test
    public void testMarshaller() {
        materielXMLUtils.marshaller(materielDtos);
        File xmlFile = new File(MaterielXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        materielXMLUtils.marshaller(materielDtos);
        List<MaterielDto> unmarshalledDtos = materielXMLUtils.unmarshaller();
        assertEquals(materielDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for (int i = 0; i < materielDtos.size(); i++) {
            assertEquals(materielDtos.get(i).getIdMateriel(), unmarshalledDtos.get(i).getIdMateriel(), "L'ID doit etre la meme");
            assertEquals(materielDtos.get(i).getNomMateriel(), unmarshalledDtos.get(i).getNomMateriel(), "Le nom doit etre la meme");
            assertEquals(materielDtos.get(i).getMarqueMateriel(), unmarshalledDtos.get(i).getMarqueMateriel(), "La marque doit etre la meme");
            assertEquals(materielDtos.get(i).getModeleMateriel(), unmarshalledDtos.get(i).getModeleMateriel(), "Le modele doit etre la meme");
            assertEquals(materielDtos.get(i).getDateAchatMateriel(), unmarshalledDtos.get(i).getDateAchatMateriel(), "La date d'achat doit etre la meme");
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(MaterielXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
