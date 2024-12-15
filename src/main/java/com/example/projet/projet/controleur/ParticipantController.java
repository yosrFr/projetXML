package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import com.example.projet.projet.service.ParticipantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping
    @ApiOperation(value = "Add a new participant", notes = "This endpoint allows to add a new participant")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Participant added successfully"),
            @ApiResponse(code = 400, message = "Invalid request data")
    })
    public ResponseEntity<Void> ajouterParticipant(@Valid @RequestBody ParticipantDto participantDto) {
        participantService.ajouterParticipant(participantDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
