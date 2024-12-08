package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonnelXMLUtilsTest {
    private PersonnelXMLUtils personnelXMLUtils;
    private List<PersonnelDto> personnelDtos;

    @BeforeEach
    public void setUp() {
        personnelXMLUtils = new PersonnelXMLUtils();
        personnelDtos = new ArrayList<>();
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Nom1", "Description1");
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Nom2", "Description2");
        personnelDtos.add(new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1, role1));
        personnelDtos.add(new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2, role2));
    }

    @Test
    public void testMarshaller() {
        personnelXMLUtils.marshaller(personnelDtos);
        File xmlFile = new File(PersonnelXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        personnelXMLUtils.marshaller(personnelDtos);
        List<PersonnelDto> unmarshalledDtos = personnelXMLUtils.unmarshaller();
        assertEquals(personnelDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < personnelDtos.size(); i++) {
            assertEquals(personnelDtos.get(i).getNom(), unmarshalledDtos.get(i).getNom(), "Le nom doit etre la meme");
            assertEquals(personnelDtos.get(i).getPrenom(), unmarshalledDtos.get(i).getPrenom(), "Le prenom doit etre la meme");
            assertEquals(personnelDtos.get(i).getAdresse(), unmarshalledDtos.get(i).getAdresse(), "L'adresse doit etre la meme");
            assertEquals(personnelDtos.get(i).getEmail(), unmarshalledDtos.get(i).getEmail(), "L'email doit etre la meme");
            assertEquals(personnelDtos.get(i).getTelephone(), unmarshalledDtos.get(i).getTelephone(), "Le numero de telephone doit etre la meme");
            assertEquals(personnelDtos.get(i).getDateNaissance(), unmarshalledDtos.get(i).getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(personnelDtos.get(i).getSexe(), unmarshalledDtos.get(i).getSexe(), "Le sexe doit etre la meme");
            assertEquals(personnelDtos.get(i).getIdPersonnel(), unmarshalledDtos.get(i).getIdPersonnel(), "L'ID doit etre la meme");
            assertEquals(personnelDtos.get(i).getRolePersonnel().getIdRolePersonnel(), unmarshalledDtos.get(i).getRolePersonnel().getIdRolePersonnel(), "L'ID du role doit etre la meme");
            assertEquals(personnelDtos.get(i).getRolePersonnel().getNomRolePersonnel(), unmarshalledDtos.get(i).getRolePersonnel().getNomRolePersonnel(), "Le nom du role doit etre la meme");
            assertEquals(personnelDtos.get(i).getRolePersonnel().getDescriptionRolePersonnel(), unmarshalledDtos.get(i).getRolePersonnel().getDescriptionRolePersonnel(), "La description doit etre la meme");
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
