package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import com.example.projet.projet.service.AffectationPersonnelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/affectations-personnel")
@Tag(name = "AffectationPersonnel", description = "API for managing personnel assignments")
public class AffectationPersonnelController {

    private final AffectationPersonnelService affectationPersonnelService;

    public AffectationPersonnelController(AffectationPersonnelService affectationPersonnelService) {
        this.affectationPersonnelService = affectationPersonnelService;
    }

    @Operation(summary = "Add a new personnel assignment")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Personnel assignment added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid assignment data provided")
    })
    @PostMapping
    public ResponseEntity<Void> ajouterAffectationPersonnel(@RequestBody AffectationPersonnelDto affectation) {
        try {
            affectationPersonnelService.ajouterAffectationPersonel(affectation);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
