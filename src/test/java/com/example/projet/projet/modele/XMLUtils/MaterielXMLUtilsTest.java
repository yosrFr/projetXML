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
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        materielXMLUtils.marshaller(materielDtos);
        List<MaterielDto> unmarshalledDtos = materielXMLUtils.unmarshaller();
        assertEquals(materielDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(materielDtos.get(0).getIdMateriel(), unmarshalledDtos.get(0).getIdMateriel(), "The ID should match");
        assertEquals(materielDtos.get(0).getNomMateriel(), unmarshalledDtos.get(0).getNomMateriel(), "The name should match");
        assertEquals(materielDtos.get(0).getMarqueMateriel(), unmarshalledDtos.get(0).getMarqueMateriel(), "The marque should match");
        assertEquals(materielDtos.get(0).getModeleMateriel(), unmarshalledDtos.get(0).getModeleMateriel(), "The modele should match");
        assertEquals(materielDtos.get(0).getDateAchatMateriel(), unmarshalledDtos.get(0).getDateAchatMateriel(), "The capacite should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
