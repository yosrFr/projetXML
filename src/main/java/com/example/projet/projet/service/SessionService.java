package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.SessionXMLUtils;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionXMLUtils sessionXMLUtils;

    public SessionService(SessionXMLUtils sessionXMLUtils) {
        this.sessionXMLUtils = sessionXMLUtils;
    }

    public void ajouterSession(SessionDto session){
        List<SessionDto> list = sessionXMLUtils.unmarshaller();
        list.add(session);
        sessionXMLUtils.marshaller(list);
    }

    public SessionDto getSessionById(long id){
        List<SessionDto> list = sessionXMLUtils.unmarshaller();
        return list.stream().filter(session -> session.getIdSession() == id).findFirst().orElse(null);
    }

    public void modifierSession(SessionDto sessionDto){
        List<SessionDto> list = sessionXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(session -> session.getIdSession() == sessionDto.getIdSession())
                .findFirst()
                .orElse(null));
        list.add(sessionDto);
        sessionXMLUtils.marshaller(list);
    }

    public void supprimerSession(long id){
        List<SessionDto> list = sessionXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(session -> session.getIdSession() == id)
                .findFirst()
                .orElse(null));
        sessionXMLUtils.marshaller(list);
    }
}
