package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.LocalDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalXMLUtilsTest {
    private LocalXMLUtils localXMLUtils;
    private List<LocalDto> localDtos;

    @BeforeEach
    public void setUp() {
        localXMLUtils = new LocalXMLUtils();
        localDtos = new ArrayList<>();
        localDtos.add(new LocalDto("adresseLocal1", 20, 1, "nomLocal1", "numTelLocal1"));
        localDtos.add(new LocalDto("adresseLocal2", 30, 2, "nomLocal2", "numTelLocal2"));
    }

    @Test
    public void testMarshaller() {
        localXMLUtils.marshaller(localDtos);
        File xmlFile = new File(LocalXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        localXMLUtils.marshaller(localDtos);
        List<LocalDto> unmarshalledDtos = localXMLUtils.unmarshaller();
        assertEquals(localDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(localDtos.get(0).getIdLocal(), unmarshalledDtos.get(0).getIdLocal(), "The ID should match");
        assertEquals(localDtos.get(0).getNomLocal(), unmarshalledDtos.get(0).getNomLocal(), "The name should match");
        assertEquals(localDtos.get(0).getAdresseLocal(), unmarshalledDtos.get(0).getAdresseLocal(), "The adress should match");
        assertEquals(localDtos.get(0).getNumTelLocal(), unmarshalledDtos.get(0).getNumTelLocal(), "The phone number should match");
        assertEquals(localDtos.get(0).getCapaciteLocal(), unmarshalledDtos.get(0).getCapaciteLocal(), "The capacite should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
