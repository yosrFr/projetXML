package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.LocalXMLUtils;
import com.example.projet.projet.modele.Dto.LocalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalService {
    @Autowired
    private LocalXMLUtils localXMLUtils;

    public LocalService(LocalXMLUtils localXMLUtils) {
        this.localXMLUtils = localXMLUtils;
    }

    public List<String> getAllNomsLocals(){
        List<LocalDto> list = localXMLUtils.unmarshaller();
        return list.stream().map(LocalDto::getNomLocal).collect(Collectors.toList());
    }

    public List<LocalDto> getAllLocals(){
        return localXMLUtils.unmarshaller();
    }

    public LocalDto getLocalById(long id){
        List<LocalDto> list = localXMLUtils.unmarshaller();
        return list.stream().filter(local -> local.getIdLocal() == id).findFirst().orElse(null);
    }

    public void ajouterLocal(LocalDto localDto){
        List<LocalDto> list = localXMLUtils.unmarshaller();
        list.add(localDto);
        localXMLUtils.marshaller(list);
    }

    public void supprimerLocal(long id){
        List<LocalDto> list = localXMLUtils.unmarshaller();
        LocalDto local = getLocalById(id);
        list.remove(local);
        localXMLUtils.marshaller(list);
    }
    public void modifierLocal(LocalDto localDto){
        List<LocalDto> list = localXMLUtils.unmarshaller();
        LocalDto local = getLocalById(localDto.getIdLocal());
        list.remove(local);
        list.add(localDto);
        localXMLUtils.marshaller(list);
    }
}
