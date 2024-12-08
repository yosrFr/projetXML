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
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        personneXMLUtils.marshaller(personneDtos);
        List<PersonneDto> unmarshalledDtos = personneXMLUtils.unmarshaller();
        assertEquals(personneDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for (int i = 0; i < personneDtos.size(); i++) {
            assertEquals(personneDtos.get(i).getNom(), unmarshalledDtos.get(i).getNom(), "Le nom doit etre la meme");
            assertEquals(personneDtos.get(i).getPrenom(), unmarshalledDtos.get(i).getPrenom(), "Le prenom doit etre la meme");
            assertEquals(personneDtos.get(i).getAdresse(), unmarshalledDtos.get(i).getAdresse(), "L'adresse doit etre la meme");
            assertEquals(personneDtos.get(i).getEmail(), unmarshalledDtos.get(i).getEmail(), "L'email doit etre la meme");
            assertEquals(personneDtos.get(i).getTelephone(), unmarshalledDtos.get(i).getTelephone(), "Le numero de telephone doit etre la meme");
            assertEquals(personneDtos.get(i).getDateNaissance(), unmarshalledDtos.get(i).getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(personneDtos.get(i).getSexe(), unmarshalledDtos.get(i).getSexe(), "Le sexe doit etre la meme");
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(PersonneXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
