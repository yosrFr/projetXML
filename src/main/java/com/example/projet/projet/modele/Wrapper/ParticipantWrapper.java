package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Participants")
public class ParticipantWrapper {
    private List<ParticipantDto> participants;

    public ParticipantWrapper() {

    }

    public ParticipantWrapper(List<ParticipantDto> participants) {
        this.participants = participants;
    }

    @XmlElement(name = "Participant")
    public List<ParticipantDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDto> participants) {
        this.participants = participants;
    }
}
