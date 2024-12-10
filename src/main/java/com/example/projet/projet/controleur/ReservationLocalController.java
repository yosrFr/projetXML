package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.ReservationLocalDto;
import com.example.projet.projet.service.ReservationLocalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations-locaux")
public class ReservationLocalController {
    private final ReservationLocalService reservationLocalService;

    @Autowired
    public ReservationLocalController(ReservationLocalService reservationLocalService) {
        this.reservationLocalService = reservationLocalService;
    }

    @PostMapping
    @ApiOperation(value = "Add a new room reservation", notes = "This endpoint allows to add a new room reservation")
    @ApiResponse(code = 201, message = "Reservation added successfully")
    public ResponseEntity<Void> addReservationLocal(@RequestBody ReservationLocalDto reservationLocalDto) {
        reservationLocalService.ajouterReservationLocal(reservationLocalDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
