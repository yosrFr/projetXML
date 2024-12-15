package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.MaterielDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaterielXMLUtilsTest {
    private final MaterielXMLUtils materielXMLUtils = new MaterielXMLUtils();
    private List<MaterielDto> materielDtos;

    @BeforeEach
    public void setUp() {
        materielDtos = new ArrayList<>();
        materielDtos.add(new MaterielDto(101, "datashow", "BenQ", "BenQ W1800i", "2022-12-12"));
        materielDtos.add(new MaterielDto(102, "TV", "LG", "OLED55B4PUA", "2022-12-23"));
    }

    @Test
    public void testMarshaller() {
        materielXMLUtils.marshaller(materielDtos);
        File xmlFile = new File(MaterielXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        materielXMLUtils.marshaller(materielDtos);
        List<MaterielDto> unmarshalledDtos = materielXMLUtils.unmarshaller();
        assertEquals(materielDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < materielDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(materielDtos.get(i)));
        }
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(MaterielXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }*/
}
