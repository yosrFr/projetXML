package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.TypeSessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypeSessionXMLUtilsTest {
    private TypeSessionXMLUtils typeSessionXMLUtils;
    private List<TypeSessionDto> typeSessionDtos;

    @BeforeEach
    public void setUp() {
        typeSessionXMLUtils = new TypeSessionXMLUtils();
        typeSessionDtos = new ArrayList<>();
        typeSessionDtos.add(new TypeSessionDto(1, "Nom1", "Description1"));
        typeSessionDtos.add(new TypeSessionDto(2, "Nom2", "Description2"));
    }

    @Test
    public void testMarshaller() {
        typeSessionXMLUtils.marshaller(typeSessionDtos);
        File xmlFile = new File(TypeSessionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        typeSessionXMLUtils.marshaller(typeSessionDtos);
        List<TypeSessionDto> unmarshalledDtos = typeSessionXMLUtils.unmarshaller();
        assertEquals(typeSessionDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for (int i = 0; i < unmarshalledDtos.size(); i++) {
            assertEquals(typeSessionDtos.get(i).getDescriptionTypeSession(), unmarshalledDtos.get(i).getDescriptionTypeSession(), "La description doit etre la meme");
            assertEquals(typeSessionDtos.get(i).getNomTypeSession(), unmarshalledDtos.get(i).getNomTypeSession(), "Le nom doit etre la meme");
            assertEquals(typeSessionDtos.get(i).getIdTypeSession(), unmarshalledDtos.get(i).getIdTypeSession(), "L'ID doit etre la meme");
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeSessionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
