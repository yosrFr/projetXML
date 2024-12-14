package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonnelXMLUtilsTest {
    private final PersonnelXMLUtils personnelXMLUtils = new PersonnelXMLUtils();
    private List<PersonnelDto> personnelDtos;

    @BeforeEach
    public void setUp() {
        personnelDtos = new ArrayList<>();
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Animateur", "Fait l'animation dans l'événement.");
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Formateur", "Fait la formation dans l'événement");
        personnelDtos.add(new PersonnelDto("Smith", "Jane", "Tunis", "jane.smith@gmail.com", "+21698765432", "2000-11-12", "femme", 1, role1));
        personnelDtos.add(new PersonnelDto("Brown", "Emily", "Bizerte", "jane.smith@gmail.com", "+21698765432", "2000-11-11", "femme", 2, role2));
    }

    @Test
    public void testMarshaller() {
        personnelXMLUtils.marshaller(personnelDtos);
        File xmlFile = new File(PersonnelXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        personnelXMLUtils.marshaller(personnelDtos);
        List<PersonnelDto> unmarshalledDtos = personnelXMLUtils.unmarshaller();
        assertEquals(personnelDtos.size(), unmarshalledDtos.size());
        for(int i = 0; i < personnelDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(personnelDtos.get(i)));
        }
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(PersonnelXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
