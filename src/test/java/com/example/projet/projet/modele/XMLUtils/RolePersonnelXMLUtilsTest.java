package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RolePersonnelXMLUtilsTest {
    private final RolePersonnelXMLUtils rolePersonnelXMLUtils = new RolePersonnelXMLUtils();
    private List<RolePersonnelDto> rolePersonnelDtos;

    @BeforeEach
    public void setUp() {
        rolePersonnelDtos = new ArrayList<>();
        rolePersonnelDtos.add(new RolePersonnelDto(1, "Animateur", "Fait l'animation dans l'événement."));
        rolePersonnelDtos.add(new RolePersonnelDto(2, "Formateur", "Fait la formation dans l'événement"));
    }

    @Test
    public void testMarshaller() {
        rolePersonnelXMLUtils.marshaller(rolePersonnelDtos);
        File xmlFile = new File(RolePersonnelXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        rolePersonnelXMLUtils.marshaller(rolePersonnelDtos);
        List<RolePersonnelDto> unmarshalledDtos = rolePersonnelXMLUtils.unmarshaller();
        assertEquals(rolePersonnelDtos.size(), unmarshalledDtos.size());
        for (int i = 0; i < rolePersonnelDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(rolePersonnelDtos.get(i)));
        }
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile = new File(RolePersonnelXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }*/
}
