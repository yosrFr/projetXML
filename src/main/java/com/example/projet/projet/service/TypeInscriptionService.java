package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.TypeInscriptionXMLUtils;
import com.example.projet.projet.modele.Dto.TypeInscriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeInscriptionService {
    @Autowired
    private TypeInscriptionXMLUtils typeInscriptionXMLUtils;

    public TypeInscriptionService(TypeInscriptionXMLUtils typeInscriptionXMLUtils) {
        this.typeInscriptionXMLUtils = typeInscriptionXMLUtils;
    }

    public List<TypeInscriptionDto> getAllTypesInscription(){
        return typeInscriptionXMLUtils.unmarshaller();
    }

    public TypeInscriptionDto getTypeInscriptionById(long id){
        List<TypeInscriptionDto> list = typeInscriptionXMLUtils.unmarshaller();
        return list.stream()
                .filter(typeInscription ->
                        typeInscription.getIdTypeInscription() == id)
                .findFirst().orElse(null);
    }

    public void ajouterTypeInscription(TypeInscriptionDto typeInscriptionDto){
        List<TypeInscriptionDto> list = typeInscriptionXMLUtils.unmarshaller();
        list.add(typeInscriptionDto);
        typeInscriptionXMLUtils.marshaller(list);
    }

    public void supprimerTypeInscription(long id){
        List<TypeInscriptionDto> list = typeInscriptionXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(typeInscription -> typeInscription.getIdTypeInscription() == id)
                .findFirst()
                .orElse(null));
        typeInscriptionXMLUtils.marshaller(list);
    }

    public void modifierTypeInscription(TypeInscriptionDto typeInscriptionDto){
        List<TypeInscriptionDto> list = typeInscriptionXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(typeInscription -> typeInscription.getIdTypeInscription() == typeInscriptionDto.getIdTypeInscription())
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Le type d'inscription pour l'ID : " + typeInscriptionDto.getIdTypeInscription() + " n'est pas trouvé")));
        list.add(typeInscriptionDto);
        typeInscriptionXMLUtils.marshaller(list);
    }
}
