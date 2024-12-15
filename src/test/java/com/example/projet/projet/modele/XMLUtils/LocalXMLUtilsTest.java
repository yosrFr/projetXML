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
    private final LocalXMLUtils localXMLUtils  = new LocalXMLUtils();
    private List<LocalDto> localDtos;

    @BeforeEach
    public void setUp() {
        localDtos = new ArrayList<>();
        localDtos.add(new LocalDto("1 Rue Centrale", 50, 101, "Salle A", "+21612345678"));
        localDtos.add(new LocalDto("2 Rue Centrale", 30, 102, "Salle B", "+21687654321"));
    }

    @Test
    public void testMarshaller() {
        localXMLUtils.marshaller(localDtos);
        File xmlFile = new File(LocalXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        localXMLUtils.marshaller(localDtos);
        List<LocalDto> unmarshalledDtos = localXMLUtils.unmarshaller();
        assertEquals(localDtos.size(), unmarshalledDtos.size());
        for(int i = 0; i < localDtos.size(); i++){
            assertTrue(unmarshalledDtos.get(i).equals(localDtos.get(i)));
        }
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(LocalXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }*/
}
