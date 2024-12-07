package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.PersonneDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonneXMLUtilsTest {
    private PersonneXMLUtils personneXMLUtils;
    private List<PersonneDto> personneDtos;

    @BeforeEach
    public void setUp() {
        personneXMLUtils = new PersonneXMLUtils();
        personneDtos = new ArrayList<>();
        personneDtos.add(new PersonneDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M"));
        personneDtos.add(new PersonneDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F"));
    }

    @Test
    public void testMarshaller() {
        personneXMLUtils.marshaller(personneDtos);
        File xmlFile = new File(PersonneXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        personneXMLUtils.marshaller(personneDtos);
        List<PersonneDto> unmarshalledDtos = personneXMLUtils.unmarshaller();
        assertEquals(personneDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(personneDtos.get(0).getNom(), unmarshalledDtos.get(0).getNom(), "The nom should match");
        assertEquals(personneDtos.get(0).getPrenom(), unmarshalledDtos.get(0).getPrenom(), "The prenom should match");
        assertEquals(personneDtos.get(0).getAdresse(), unmarshalledDtos.get(0).getAdresse(), "The adress should match");
        assertEquals(personneDtos.get(0).getEmail(), unmarshalledDtos.get(0).getEmail(), "The email should match");
        assertEquals(personneDtos.get(0).getTelephone(), unmarshalledDtos.get(0).getTelephone(), "The tel should match");
        assertEquals(personneDtos.get(0).getDateNaissance(), unmarshalledDtos.get(0).getDateNaissance(), "The date should match");
        assertEquals(personneDtos.get(0).getSexe(), unmarshalledDtos.get(0).getSexe(), "The sexe should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
