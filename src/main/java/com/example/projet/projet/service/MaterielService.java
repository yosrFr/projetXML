package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.MaterielXMLUtils;
import com.example.projet.projet.modele.Dto.MaterielDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MaterielService {
    @Autowired
    private MaterielXMLUtils materielXMLUtils;
    @Autowired
    private ReservationMaterielService reservationMaterielService;

    public MaterielService(MaterielXMLUtils materielXMLUtils, ReservationMaterielService reservationMaterielService) {
        this.materielXMLUtils = materielXMLUtils;
        this.reservationMaterielService = reservationMaterielService;
    }

    public List<String> getAllNomsMaterielsDispo(LocalTime tempsDebut, LocalTime tempsFin, Date date){
        List<String> nomsMaterielsDispo = new ArrayList<String>();
        List<MaterielDto> list = materielXMLUtils.unmarshaller();
        for (MaterielDto materiel: list){
            if(!reservationMaterielService.estReservé(materiel.getIdMateriel(), tempsDebut, tempsFin, date)){
                nomsMaterielsDispo.add(materiel.getNomMateriel());
            }
        }
        return nomsMaterielsDispo;
    }

    public List<MaterielDto> getAllMateriels(){
        return materielXMLUtils.unmarshaller();
    }

    public MaterielDto getMaterielById(long id){
        List<MaterielDto> list = materielXMLUtils.unmarshaller();
        return list.stream().filter(materiel -> materiel.getIdMateriel() == id).findFirst().orElse(null);
    }

    public void modifierMateriel(MaterielDto materielDto){
        List<MaterielDto> list = materielXMLUtils.unmarshaller();
        MaterielDto materiel = getMaterielById(materielDto.getIdMateriel());
        list.remove(materiel);
        list.add(materielDto);
        materielXMLUtils.marshaller(list);
    }

    public void ajouterMateriel(MaterielDto materielDto){
        List<MaterielDto> list = materielXMLUtils.unmarshaller();
        list.add(materielDto);
        materielXMLUtils.marshaller(list);
    }

    public void supprimerMateriel(long id){
        List<MaterielDto> list = materielXMLUtils.unmarshaller();
        MaterielDto materiel = getMaterielById(id);
        list.remove(materiel);
        materielXMLUtils.marshaller(list);
    }
}