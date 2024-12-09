package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import com.example.projet.projet.modele.XMLUtils.PersonnelXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonnelServiceTest {
    private PersonnelService personnelService;
    private PersonnelXMLUtils personnelXMLUtils;
    private List<PersonnelDto> personnelDtos;

    @BeforeEach
    public void setUp() {
        personnelXMLUtils = new PersonnelXMLUtils();
        personnelService = new PersonnelService(personnelXMLUtils);
        personnelDtos = new ArrayList<>();
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Nom1", "Description1");
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Nom2", "Description2");
        personnelDtos.add(new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1, role1));
        personnelDtos.add(new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2, role2));
        personnelXMLUtils.marshaller(personnelDtos);
    }

    @Test
    public void testGetAllNomsPersonnelDispoByRole() {}

    @Test
    public void testGetAllPersonel() {
        List<PersonnelDto> result = personnelService.getAllPersonnel();
        assertEquals(personnelDtos.size(), result.size());
    }

    @Test
    public void testGetPersonnelById() {
        for (int i = 0; i < personnelDtos.size(); i++) {
            PersonnelDto result = personnelService.getPersonnelById(personnelDtos.get(i).getIdPersonnel());
            assertNotNull(result);
            assertEquals(personnelDtos.get(i).getIdPersonnel(), result.getIdPersonnel());
            assertEquals(personnelDtos.get(i).getNom(), result.getNom());
            assertEquals(personnelDtos.get(i).getPrenom(), result.getPrenom());
            assertEquals(personnelDtos.get(i).getAdresse(), result.getAdresse());
            assertEquals(personnelDtos.get(i).getEmail(), result.getEmail());
            assertEquals(personnelDtos.get(i).getTelephone(), result.getTelephone());
            assertEquals(personnelDtos.get(i).getSexe(), result.getSexe());
            assertEquals(personnelDtos.get(i).getDateNaissance(), result.getDateNaissance());
            assertEquals(personnelDtos.get(i).getRolePersonnel().getIdRolePersonnel(), result.getRolePersonnel().getIdRolePersonnel());
            assertEquals(personnelDtos.get(i).getRolePersonnel().getNomRolePersonnel(), result.getRolePersonnel().getNomRolePersonnel());
            assertEquals(personnelDtos.get(i).getRolePersonnel().getDescriptionRolePersonnel(), result.getRolePersonnel().getDescriptionRolePersonnel());
        }
    }

    @Test
    public void testAjouterPersonnel() {
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Nom2", "Description2");
        PersonnelDto newPersonnel = new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 3, role2);
        personnelService.ajouterPersonnel(newPersonnel);
        List<PersonnelDto> result = personnelService.getAllPersonnel();
        assertEquals(personnelDtos.size() + 1, result.size());
    }

    @Test
    public void testModifierPersonnel() {
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Nom2", "Description2");
        PersonnelDto updatedPersonnel = new PersonnelDto("nom_updated", "prenom", "adresse", "email", "telephone", new Date(), "F", 2, role2);
        personnelService.modifierPersonnel(updatedPersonnel);
        PersonnelDto result = personnelService.getPersonnelById(updatedPersonnel.getIdPersonnel());
        assertEquals("nom_updated", result.getNom());
        assertEquals(2, result.getIdPersonnel());
    }

    @Test
    public void testSupprimerPersonnel() {
        personnelService.supprimerPersonnel(1);
        List<PersonnelDto> result = personnelService.getAllPersonnel();
        assertEquals(personnelDtos.size() - 1, result.size());
        assertNull(personnelService.getPersonnelById(1));
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(PersonnelXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
