package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.InscriptionDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Inscriptions")
public class InscriptionWrapper {
    private List<InscriptionDto> inscriptions;

    public InscriptionWrapper() {

    }

    public InscriptionWrapper(List<InscriptionDto> inscriptions) {
        this.inscriptions = inscriptions;
    }

    @XmlElement(name = "Inscription")
    public List<InscriptionDto> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<InscriptionDto> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
