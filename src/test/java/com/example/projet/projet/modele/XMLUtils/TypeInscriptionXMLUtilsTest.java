package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.TypeInscriptionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypeInscriptionXMLUtilsTest {
    private TypeInscriptionXMLUtils typeInscriptionXMLUtils;
    private List<TypeInscriptionDto> typeInscriptionDtos;

    @BeforeEach
    public void setUp() {
        typeInscriptionXMLUtils = new TypeInscriptionXMLUtils();
        typeInscriptionDtos = new ArrayList<>();
        typeInscriptionDtos.add(new TypeInscriptionDto("Description1", "Nom1", 1L));
        typeInscriptionDtos.add(new TypeInscriptionDto("Description2", "Nom2", 2L));
    }

    @Test
    public void testMarshaller() {
        typeInscriptionXMLUtils.marshaller(typeInscriptionDtos);
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        typeInscriptionXMLUtils.marshaller(typeInscriptionDtos);
        List<TypeInscriptionDto> unmarshalledDtos = typeInscriptionXMLUtils.unmarshaller();
        assertEquals(typeInscriptionDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(typeInscriptionDtos.get(0).getDescriptionTypeInscription(), unmarshalledDtos.get(0).getDescriptionTypeInscription(), "The description should match");
        assertEquals(typeInscriptionDtos.get(0).getNomTypeInscription(), unmarshalledDtos.get(0).getNomTypeInscription(), "The name should match");
        assertEquals(typeInscriptionDtos.get(0).getIdTypeInscription(), unmarshalledDtos.get(0).getIdTypeInscription(), "The ID should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}

