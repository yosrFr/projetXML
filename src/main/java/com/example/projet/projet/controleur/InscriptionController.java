package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.InscriptionDto;
import com.example.projet.projet.service.InscriptionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
@Validated
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @Autowired
    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping
    @ApiOperation(value = "Retrieve all inscriptions for an event", notes = "This endpoint returns a list of all inscriptions for a specific event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all inscriptions"),
            @ApiResponse(code = 204, message = "No inscriptions found for this event")
    })
    public ResponseEntity<List<InscriptionDto>> getAllInscriptionsByEvenenemnt(@RequestParam("idEvenement") long idEvenement) {
        List<InscriptionDto> inscriptions = inscriptionService.getAllInscriptionsByEvenenemnt(idEvenement);
        if (inscriptions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inscriptions);
    }

    @GetMapping("/order-date")
    @ApiOperation(value = "Retrieve all inscriptions for an event ordered by date", notes = "This endpoint returns a list of inscriptions for a specific event ordered by date of inscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all inscriptions ordered by date"),
            @ApiResponse(code = 204, message = "No inscriptions found for this event ordered by date")
    })
    public ResponseEntity<List<InscriptionDto>> getAllInscriptionsByEvenementOrderdByDate(@RequestParam("idEvenement") long idEvenement) {
        List<InscriptionDto> inscriptions = inscriptionService.getAllInscriptionsByEvenementOrderdByDate(idEvenement);
        if (inscriptions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inscriptions);
    }

    @PostMapping
    @ApiOperation(value = "Create a new inscription", notes = "This endpoint allows to create a new inscription for an event")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Inscription created successfully"),
            @ApiResponse(code = 400, message = "Invalid request data")
    })
    public ResponseEntity<Void> addInscription(@Valid @RequestBody InscriptionDto inscriptionDto) {
        inscriptionService.ajouterInscription(inscriptionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
