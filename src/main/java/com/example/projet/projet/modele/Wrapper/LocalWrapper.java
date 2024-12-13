package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.LocalDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Locaux")
public class LocalWrapper {
    private List<LocalDto> locals;

    public LocalWrapper() {

    }

    public LocalWrapper(List<LocalDto> locals) {
        this.locals = locals;
    }

    @XmlElement(name = "Local")
    public List<LocalDto> getLocals() {
        return locals;
    }

    public void setLocals(List<LocalDto> locals) {
        this.locals = locals;
    }
}
