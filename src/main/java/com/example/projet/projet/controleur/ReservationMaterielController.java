package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import com.example.projet.projet.service.ReservationMaterielService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations-materiel")
public class ReservationMaterielController {
    private final ReservationMaterielService reservationMaterielService;

    @Autowired
    public ReservationMaterielController(ReservationMaterielService reservationMaterielService) {
        this.reservationMaterielService = reservationMaterielService;
    }

    @PostMapping
    @ApiOperation(value = "Add a new material reservation", notes = "This endpoint allows to add a new material reservation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Reservation added successfully"),
            @ApiResponse(code = 400, message = "Invalid request data")
    })
    public ResponseEntity<Void> addReservationMateriel(@RequestBody ReservationMaterielsDto reservationMaterielDto) {
        reservationMaterielService.ajouterReservationMateriel(reservationMaterielDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
