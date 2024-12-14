package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class EvenementDto {
    @NotNull
    private long idEvenement;
    @NotNull
    @Size(max = 30)
    private String titreEvenement;
    @Size(min = 10, max = 200)
    private String descriptionEvenement;
    @NotNull
    private String dateDebutEvenement;
    @NotNull
    private String dateFinEvenement;
    private int nombreParticipantsEstime;
    @NotNull
    private int nombreParticipantsMaximal;
    @NotNull
    private List<SessionDto> sessions;
    @NotNull
    private CategorieEvenementDto categorieEvenement;

    public EvenementDto() {
        super();
        sessions = new ArrayList<SessionDto>();
    }

    public EvenementDto(long idEvenement, String titreEvenement, String descriptionEvenement, String dateDebutEvenement, String dateFinEvenement, int nombreParticipantsEstime, int nombreParticipantsMaximal, List<SessionDto> sessions, CategorieEvenementDto categorieEvenement) {
        this.idEvenement = idEvenement;
        this.titreEvenement = titreEvenement;
        this.descriptionEvenement = descriptionEvenement;
        this.dateDebutEvenement = dateDebutEvenement;
        this.dateFinEvenement = dateFinEvenement;
        this.nombreParticipantsEstime = nombreParticipantsEstime;
        this.nombreParticipantsMaximal = nombreParticipantsMaximal;
        this.sessions = sessions;
        this.categorieEvenement = categorieEvenement;
    }

    @XmlElement (name = "IdEvenet")
    public long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(long idEvenement) {
        this.idEvenement = idEvenement;
    }

    @XmlElement (name = "TitreEvent")
    public String getTitreEvenement() {
        return titreEvenement;
    }

    public void setTitreEvenement(String titreEvenement) {
        this.titreEvenement = titreEvenement;
    }

    @XmlElement (name = "DescriptionEvent")
    public String getDescriptionEvenement() {
        return descriptionEvenement;
    }

    public void setDescriptionEvenement(String descriptionEvenement) {
        this.descriptionEvenement = descriptionEvenement;
    }

    @XmlElement (name = "DateDebutEvent")
    public String getDateDebutEvenement() {
        return dateDebutEvenement;
    }

    public void setDateDebutEvenement(String dateDebutEvenement) {
        this.dateDebutEvenement = dateDebutEvenement;
    }

    @XmlElement (name = "DateFinEvent")
    public String getDateFinEvenement() {
        return dateFinEvenement;
    }

    public void setDateFinEvenement(String dateFinEvenement) {
        this.dateFinEvenement = dateFinEvenement;
    }

    @XmlElement (name = "NbParEstim")
    public int getNombreParticipantsEstime() {
        return nombreParticipantsEstime;
    }

    public void setNombreParticipantsEstime(int nombreParticipantsEstime) {
        this.nombreParticipantsEstime = nombreParticipantsEstime;
    }

    @XmlElement (name = "NbParMax")
    public int getNombreParticipantsMaximal() {
        return nombreParticipantsMaximal;
    }

    public void setNombreParticipantsMaximal(int nombreParticipantsMaximal) {
        this.nombreParticipantsMaximal = nombreParticipantsMaximal;
    }

    @XmlElement (name = "Sessions")
    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }

    @XmlElement (name = "CategoriesEvenement")
    public CategorieEvenementDto getCategorieEvenement() {
        return categorieEvenement;
    }

    public void setCategorieEvenement(CategorieEvenementDto categorieEvenement) {
        this.categorieEvenement = categorieEvenement;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EvenementDto that)) return false;
        return idEvenement == that.idEvenement && nombreParticipantsEstime == that.nombreParticipantsEstime && nombreParticipantsMaximal == that.nombreParticipantsMaximal && Objects.equals(titreEvenement, that.titreEvenement) && Objects.equals(descriptionEvenement, that.descriptionEvenement) && Objects.equals(dateDebutEvenement, that.dateDebutEvenement) && Objects.equals(dateFinEvenement, that.dateFinEvenement) && Objects.equals(sessions, that.sessions) && Objects.equals(categorieEvenement, that.categorieEvenement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvenement, titreEvenement, descriptionEvenement, dateDebutEvenement, dateFinEvenement, nombreParticipantsEstime, nombreParticipantsMaximal, sessions, categorieEvenement);
    }
}
