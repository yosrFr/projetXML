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
    private final TypeInscriptionXMLUtils typeInscriptionXMLUtils = new TypeInscriptionXMLUtils();
    private List<TypeInscriptionDto> typeInscriptionDtos;

    @BeforeEach
    public void setUp() {
        typeInscriptionDtos = new ArrayList<>();
        typeInscriptionDtos.add(new TypeInscriptionDto("Inscription générale pour assister à l'événement sans conditions particulières", "Standard", 1));
        typeInscriptionDtos.add(new TypeInscriptionDto("Inscription offrant des avantages exclusifs comme des sièges privilégiés et un accès à des événements privés", "VIP", 2));
        typeInscriptionDtos.add(new TypeInscriptionDto("Inscription avec tarif réduit pour les étudiants, sur présentation de la carte étudiante", "Étudiant", 3));
        typeInscriptionDtos.add(new TypeInscriptionDto("Inscription destinée aux enseignants, avec des avantages comme des tarifs réduits ou une inscription gratuite.", "Enseignant", 4));
    }

    @Test
    public void testMarshaller() {
        typeInscriptionXMLUtils.marshaller(typeInscriptionDtos);
        File xmlFile = new File(TypeInscriptionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        typeInscriptionXMLUtils.marshaller(typeInscriptionDtos);
        List<TypeInscriptionDto> unmarshalledDtos = typeInscriptionXMLUtils.unmarshaller();
        assertEquals(typeInscriptionDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < typeInscriptionDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(typeInscriptionDtos.get(i)));
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

