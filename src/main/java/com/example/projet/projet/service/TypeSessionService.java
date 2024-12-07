package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.TypeSessionXMLUtils;
import com.example.projet.projet.modele.Dto.TypeSessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeSessionService {
    @Autowired
    private TypeSessionXMLUtils typeSessionXMLUtils;

    public TypeSessionService(TypeSessionXMLUtils typeSessionXMLUtils) {
        this.typeSessionXMLUtils = typeSessionXMLUtils;
    }

    public List<String> getALLNomsTypesSession(){
        List<TypeSessionDto> list = typeSessionXMLUtils.unmarshaller();
        return list.stream().map(TypeSessionDto::getNomTypeSession).collect(Collectors.toList());
    }

    public List<TypeSessionDto> getAllTypesSession(){
        return typeSessionXMLUtils.unmarshaller();
    }

    public TypeSessionDto getTypeSessionById(long id){
        List<TypeSessionDto> list = typeSessionXMLUtils.unmarshaller();
        return list.stream().filter(typeSession -> typeSession.getIdTypeSession() == id).findFirst().orElse(null);
    }

    public void ajouterTypeSession(TypeSessionDto typeSession){
        List<TypeSessionDto> list = typeSessionXMLUtils.unmarshaller();
        list.add(typeSession);
        typeSessionXMLUtils.marshaller(list);
    }

    public void modifierTypeSession(TypeSessionDto typeSessionDto){
        List<TypeSessionDto> list = typeSessionXMLUtils.unmarshaller();
        TypeSessionDto typeSession = getTypeSessionById(typeSessionDto.getIdTypeSession());
        list.remove(typeSession);
        list.add(typeSessionDto);
        typeSessionXMLUtils.marshaller(list);
    }

    public void supprimerTypeSession(long id){
        List<TypeSessionDto> list = typeSessionXMLUtils.unmarshaller();
        TypeSessionDto typeSession = getTypeSessionById(id);
        list.remove(typeSession);
        typeSessionXMLUtils.marshaller(list);
    }
}
