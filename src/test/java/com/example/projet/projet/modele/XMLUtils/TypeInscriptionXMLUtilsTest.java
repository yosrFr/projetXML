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
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        typeInscriptionXMLUtils.marshaller(typeInscriptionDtos);
        List<TypeInscriptionDto> unmarshalledDtos = typeInscriptionXMLUtils.unmarshaller();
        assertEquals(typeInscriptionDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for (int i = 0; i < unmarshalledDtos.size(); i++) {
            assertEquals(typeInscriptionDtos.get(i).getDescriptionTypeInscription(), unmarshalledDtos.get(i).getDescriptionTypeInscription(), "La description doit etre la meme");
            assertEquals(typeInscriptionDtos.get(i).getNomTypeInscription(), unmarshalledDtos.get(i).getNomTypeInscription(), "Le nom doit etre la meme");
            assertEquals(typeInscriptionDtos.get(i).getIdTypeInscription(), unmarshalledDtos.get(i).getIdTypeInscription(), "L'ID doit etre la meme");
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}

