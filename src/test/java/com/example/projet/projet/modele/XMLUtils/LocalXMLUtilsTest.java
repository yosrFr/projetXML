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
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        localXMLUtils.marshaller(localDtos);
        List<LocalDto> unmarshalledDtos = localXMLUtils.unmarshaller();
        assertEquals(localDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < unmarshalledDtos.size(); i++){
            assertEquals(localDtos.get(i).getIdLocal(), unmarshalledDtos.get(i).getIdLocal(), "L'ID doit etre la meme");
            assertEquals(localDtos.get(i).getNomLocal(), unmarshalledDtos.get(i).getNomLocal(), "Le nom doit etre la meme");
            assertEquals(localDtos.get(i).getAdresseLocal(), unmarshalledDtos.get(i).getAdresseLocal(), "L'adresse doit etre la meme");
            assertEquals(localDtos.get(i).getNumTelLocal(), unmarshalledDtos.get(i).getNumTelLocal(), "Le numero de telephone doit etre la meme");
            assertEquals(localDtos.get(i).getCapaciteLocal(), unmarshalledDtos.get(i).getCapaciteLocal(), "La capacite doit etre la meme");
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(LocalXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
