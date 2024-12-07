package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.TypeInscriptionDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "TypesInscription")
public class TypeInscriptionWrapper {
    private List<TypeInscriptionDto> typesInscription;

    public TypeInscriptionWrapper() {}

    public TypeInscriptionWrapper(List<TypeInscriptionDto> typesInscription) {
        this.typesInscription = typesInscription;
    }

    @XmlElement(name = "typeInscription")
    public List<TypeInscriptionDto> getTypesInscription() {
        return typesInscription;
    }

    public void setTypesInscription(List<TypeInscriptionDto> typesInscription) {
        this.typesInscription = typesInscription;
    }
}
