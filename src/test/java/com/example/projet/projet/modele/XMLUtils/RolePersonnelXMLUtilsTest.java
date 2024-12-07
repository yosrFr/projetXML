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
    private RolePersonnelXMLUtils rolePersonnelXMLUtils;
    private List<RolePersonnelDto> rolePersonnelDtos;

    @BeforeEach
    public void setUp() {
        rolePersonnelXMLUtils = new RolePersonnelXMLUtils();
        rolePersonnelDtos = new ArrayList<>();
        rolePersonnelDtos.add(new RolePersonnelDto(1, "Nom1", "Description1"));
        rolePersonnelDtos.add(new RolePersonnelDto(2, "Nom2", "Description2"));
    }

    @Test
    public void testMarshaller() {
        rolePersonnelXMLUtils.marshaller(rolePersonnelDtos);
        File xmlFile = new File(RolePersonnelXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "XML file should exist");
        assertTrue(xmlFile.length() > 0, "XML file ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        rolePersonnelXMLUtils.marshaller(rolePersonnelDtos);
        List<RolePersonnelDto> unmarshalledDtos = rolePersonnelXMLUtils.unmarshaller();
        assertEquals(rolePersonnelDtos.size(), unmarshalledDtos.size(), "The size of unmarshalled list should match");
        assertEquals(rolePersonnelDtos.get(0).getDescriptionRolePersonnel(), unmarshalledDtos.get(0).getDescriptionRolePersonnel(), "The description should match");
        assertEquals(rolePersonnelDtos.get(0).getNomRolePersonnel(), unmarshalledDtos.get(0).getNomRolePersonnel(), "The name should match");
        assertEquals(rolePersonnelDtos.get(0).getIdRolePersonnel(), unmarshalledDtos.get(0).getIdRolePersonnel(), "The ID should match");
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(RolePersonnelXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
