package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.SessionDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Sessions")
public class SessionWrapper {
    private List<SessionDto> sessions;

    public SessionWrapper() {

    }

    public SessionWrapper(List<SessionDto> sessions) {
        this.sessions = sessions;
    }

    @XmlElement(name = "Session")
    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }
}
