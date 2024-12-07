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
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        typeSessionXMLUtils.marshaller(typeSessionDtos);
        List<TypeSessionDto> unmarshalledDtos = typeSessionXMLUtils.unmarshaller();
        assertEquals(typeSessionDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(typeSessionDtos.get(0).getDescriptionTypeSession(), unmarshalledDtos.get(0).getDescriptionTypeSession(), "The description should match");
        assertEquals(typeSessionDtos.get(0).getNomTypeSession(), unmarshalledDtos.get(0).getNomTypeSession(), "The name should match");
        assertEquals(typeSessionDtos.get(0).getIdTypeSession(), unmarshalledDtos.get(0).getIdTypeSession(), "The ID should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
