package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.RolePersonnelXMLUtils;
import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolePersonnelService {
    @Autowired
    private RolePersonnelXMLUtils rolePersonnelXMLUtils;

    public RolePersonnelService(RolePersonnelXMLUtils rolePersonnelXMLUtils) {
        this.rolePersonnelXMLUtils = rolePersonnelXMLUtils;
    }

    public List<String> getALLNomsRolesPersonnel(){
        List<RolePersonnelDto> list = rolePersonnelXMLUtils.unmarshaller();
        return list.stream().map(RolePersonnelDto::getNomRolePersonnel).collect(Collectors.toList());
    }

    public List<RolePersonnelDto> getAllRolesPersonnel(){
        return rolePersonnelXMLUtils.unmarshaller();
    }

    public RolePersonnelDto getRolePersonnelById(long id){
        List<RolePersonnelDto> list = rolePersonnelXMLUtils.unmarshaller();
        return list.stream()
                .filter(rolePersonnel ->
                        rolePersonnel.getIdRolePersonnel() == id)
                .findFirst().orElse(null);
    }

    public void modifierRolePerssonnel(RolePersonnelDto rolePersonnelDto){
        List<RolePersonnelDto> list = rolePersonnelXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(role -> role.getIdRolePersonnel() == rolePersonnelDto.getIdRolePersonnel())
                .findFirst()
                .orElse(null));
        list.add(rolePersonnelDto);
        rolePersonnelXMLUtils.marshaller(list);
    }

    public void ajouterRolePersonnel(RolePersonnelDto rolePersonnelDto){
        List<RolePersonnelDto> list = rolePersonnelXMLUtils.unmarshaller();
        list.add(rolePersonnelDto);
        rolePersonnelXMLUtils.marshaller(list);
    }

    public void supprimerRolePersonnel(long id){
        List<RolePersonnelDto> list = rolePersonnelXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(role -> role.getIdRolePersonnel() == id)
                .findFirst()
                .orElse(null));
        rolePersonnelXMLUtils.marshaller(list);
    }
}
