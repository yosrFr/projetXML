package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.PersonnelXMLUtils;
import com.example.projet.projet.modele.Dto.PersonnelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonnelService {
    @Autowired
    private PersonnelXMLUtils personnelXMLUtils;
    @Autowired
    private ReservationMaterielService reservationMaterielService;

    public PersonnelService(PersonnelXMLUtils personnelXMLUtils, ReservationMaterielService reservationMaterielService) {
        this.personnelXMLUtils = personnelXMLUtils;
        this.reservationMaterielService = reservationMaterielService;
    }

    public List<String> getAllNomsPersonnelDispoByRole (String role, Date date, LocalTime tempsDeb, LocalTime tempsFin){
        List<String> nomsPersonnel = new ArrayList<>();
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        List<PersonnelDto> persoParRole = list.stream().filter(personnel -> personnel.getRolePersonnel().equals(role)).collect(Collectors.toList());
        for(PersonnelDto personnelDto : persoParRole){
            if(!reservationMaterielService.estReservé(personnelDto.getIdPersonnel(), tempsDeb, tempsFin, date)){
                nomsPersonnel.add(personnelDto.getNom());
            }
        }
        return nomsPersonnel;
    }

    public List<PersonnelDto> getAllPersonnel(){
        return personnelXMLUtils.unmarshaller();
    }

    public PersonnelDto getPersonnelById(long id){
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        return list.stream().filter(personnel -> personnel.getIdPersonnel() == id).findFirst().orElse(null);
    }

    public void ajouterPersonnel(PersonnelDto personnelDto){
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        list.add(personnelDto);
        personnelXMLUtils.marshaller(list);
    }

    public void modifierPersonnel(PersonnelDto personnelDto){
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        PersonnelDto personnel = getPersonnelById(personnelDto.getIdPersonnel());
        list.remove(personnel);
        list.add(personnelDto);
        personnelXMLUtils.marshaller(list);
    }

    public void supprimerPersonnel(long id){
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        PersonnelDto personnel = getPersonnelById(id);
        list.remove(personnel);
        personnelXMLUtils.marshaller(list);
    }
}
