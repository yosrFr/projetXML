package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.PersonnelXMLUtils;
import com.example.projet.projet.modele.Dto.PersonnelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonnelService {
    @Autowired
    private PersonnelXMLUtils personnelXMLUtils;
    @Autowired
    private AffectationPersonnelService affectationPersonnelService;

    public PersonnelService(PersonnelXMLUtils personnelXMLUtils) {
        this.personnelXMLUtils = personnelXMLUtils;
    }

    public List<String> getAllNomsPersonnelDispoByRole (String nomRole, String date, String tempsDeb, String tempsFin){
        List<String> nomsPersonnel = new ArrayList<>();
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        List<PersonnelDto> persoParRole = list.stream()
                .filter(personnel ->
                        personnel.getRolePersonnel().equals(nomRole)).collect(Collectors.toList());
        for(PersonnelDto personnelDto : persoParRole){
            if(!affectationPersonnelService.estAffecté(personnelDto.getIdPersonnel(), tempsDeb, tempsFin, date)){
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
        return list.stream()
                .filter(personnel ->
                        personnel.getIdPersonnel() == id)
                .findFirst().orElse(null);
    }

    public void ajouterPersonnel(PersonnelDto personnelDto){
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        list.add(personnelDto);
        personnelXMLUtils.marshaller(list);
    }

    public void modifierPersonnel(PersonnelDto personnelDto){
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(personnel -> personnel.getIdPersonnel() == personnelDto.getIdPersonnel())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Le personnel avec l'ID : " + personnelDto.getIdPersonnel() + " n'est pas trouvé")));
        list.add(personnelDto);
        personnelXMLUtils.marshaller(list);
    }

    public void supprimerPersonnel(long id){
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(personnel -> personnel.getIdPersonnel() == id)
                .findFirst()
                .orElse(null));
        personnelXMLUtils.marshaller(list);
    }
}
