package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import com.example.projet.projet.modele.XMLUtils.ParticipantXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantXMLUtils participantXMLUtils;

    public ParticipantService(ParticipantXMLUtils participantXMLUtils) {
        this.participantXMLUtils = participantXMLUtils;
    }

    public void ajouterParticipant(ParticipantDto participantDto) {
        List<ParticipantDto> list = participantXMLUtils.unmarshaller();
        list.add(participantDto);
        participantXMLUtils.marshaller(list);
    }
}
