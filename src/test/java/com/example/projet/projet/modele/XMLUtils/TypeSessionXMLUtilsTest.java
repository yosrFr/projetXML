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
    private final TypeSessionXMLUtils typeSessionXMLUtils = new TypeSessionXMLUtils();
    private List<TypeSessionDto> typeSessionDtos;

    @BeforeEach
    public void setUp() {
        typeSessionDtos = new ArrayList<>();
        typeSessionDtos.add(new TypeSessionDto(1, "Plénière", "Session plénière pour tous les participants."));
        typeSessionDtos.add(new TypeSessionDto(2, "Workshop", "Session interactive en petits groupes."));
    }

    @Test
    public void testMarshaller() {
        typeSessionXMLUtils.marshaller(typeSessionDtos);
        File xmlFile = new File(TypeSessionXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        typeSessionXMLUtils.marshaller(typeSessionDtos);
        List<TypeSessionDto> unmarshalledDtos = typeSessionXMLUtils.unmarshaller();
        assertEquals(typeSessionDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < typeSessionDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(typeSessionDtos.get(i)));
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
