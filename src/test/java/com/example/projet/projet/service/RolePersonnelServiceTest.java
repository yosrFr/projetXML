package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import com.example.projet.projet.modele.XMLUtils.RolePersonnelXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RolePersonnelServiceTest {
    private RolePersonnelService rolePersonnelService;
    private RolePersonnelXMLUtils rolePersonnelXMLUtils;
    private List<RolePersonnelDto> rolePersonnelDtos;

    @BeforeEach
    public void setUp() {
        rolePersonnelXMLUtils = new RolePersonnelXMLUtils();
        rolePersonnelService = new RolePersonnelService(rolePersonnelXMLUtils);
        rolePersonnelDtos = new ArrayList<>();
        rolePersonnelDtos.add(new RolePersonnelDto(1, "Nom1", "Description1"));
        rolePersonnelDtos.add(new RolePersonnelDto(2, "Nom2", "Description2"));
        rolePersonnelXMLUtils.marshaller(rolePersonnelDtos);
    }

    @Test
    public void testGetALLNomsRolesPersonnel() {
        List<String> result = rolePersonnelService.getALLNomsRolesPersonnel();
        List<String> nomsRolesPersonnels = rolePersonnelDtos.stream().map(RolePersonnelDto::getNomRolePersonnel).collect(Collectors.toList());
        assertEquals(nomsRolesPersonnels, result);
    }

    @Test
    public void testGetAllRolesPersonnel() {
        List<RolePersonnelDto> result = rolePersonnelService.getAllRolesPersonnel();
        assertEquals(rolePersonnelDtos.size(), result.size());
    }

    @Test
    public void testGetRolePersonnelById() {
        for (int i = 0; i < rolePersonnelDtos.size(); i++) {
            RolePersonnelDto result = rolePersonnelService.getRolePersonnelById(rolePersonnelDtos.get(i).getIdRolePersonnel());
            assertEquals(rolePersonnelDtos.get(i).getIdRolePersonnel(), result.getIdRolePersonnel());
            assertEquals(rolePersonnelDtos.get(i).getNomRolePersonnel(), result.getNomRolePersonnel());
            assertEquals(rolePersonnelDtos.get(i).getDescriptionRolePersonnel(), result.getDescriptionRolePersonnel());
        }
    }

    @Test
    public void testModifierRolePersonnel() {
        RolePersonnelDto updatedRolePersonnel = new RolePersonnelDto(2, "Nom4", "Description2");
        rolePersonnelService.modifierRolePerssonnel(updatedRolePersonnel);
        RolePersonnelDto result = rolePersonnelService.getRolePersonnelById(2);
        assertNotNull(result);
        assertEquals("Nom4", result.getNomRolePersonnel());
        assertEquals(2, result.getIdRolePersonnel());
    }

    @Test
    public void testAjouterRolePersonnel() {
        RolePersonnelDto newRolePersonnel = new RolePersonnelDto(3, "Nom2", "Description2");
        rolePersonnelService.ajouterRolePersonnel(newRolePersonnel);
        List<RolePersonnelDto> result = rolePersonnelService.getAllRolesPersonnel();
        assertEquals(rolePersonnelDtos.size() + 1, result.size());
    }

    @Test
    public void testSupprimerRolePersonnel() {
        rolePersonnelService.supprimerRolePersonnel(1);
        List<RolePersonnelDto> result = rolePersonnelService.getAllRolesPersonnel();
        assertEquals(rolePersonnelDtos.size() - 1, result.size());
        assertNull(rolePersonnelService.getRolePersonnelById(1));
    }

    @AfterEach
    public void tearDown() {
        File xmlFile = new File(RolePersonnelXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
