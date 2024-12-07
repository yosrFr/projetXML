package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.TypeSessionDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "TypesSession")
public class TypeSessionWrapper {
    private List<TypeSessionDto> typeSession;

    public TypeSessionWrapper() {

    }

    public TypeSessionWrapper(List<TypeSessionDto> typeSession) {
        this.typeSession = typeSession;
    }

    @XmlElement(name = "typeSession")
    public List<TypeSessionDto> getTypeSession() {
        return typeSession;
    }

    public void setTypeSession(List<TypeSessionDto> typeSession) {
        this.typeSession = typeSession;
    }
}
