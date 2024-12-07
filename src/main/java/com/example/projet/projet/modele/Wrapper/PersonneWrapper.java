package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.PersonneDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Personnes")
public class PersonneWrapper {
    private List<PersonneDto> personnes;

    public PersonneWrapper() {

    }
    public PersonneWrapper(List<PersonneDto> personnes) {
        this.personnes = personnes;
    }

    @XmlElement(name = "Personne")
    public List<PersonneDto> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<PersonneDto> personnes) {
        this.personnes = personnes;
    }
}
