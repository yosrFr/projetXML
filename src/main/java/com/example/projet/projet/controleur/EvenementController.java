package com.example.projet.projet.controller;

import com.example.projet.projet.modele.Dto.EvenementDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.service.EvenementService;
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
@RequestMapping("/api/evenements")
@Validated
public class EvenementController {

    private final EvenementService evenementService;

    @Autowired
    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping
    @ApiOperation(value = "Retrieve all events", notes = "This endpoint returns a list of all events")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all events"),
            @ApiResponse(code = 204, message = "No events found")
    })
    public ResponseEntity<List<EvenementDto>> getAllEvenements() {
        List<EvenementDto> evenements = evenementService.getAllEvenements();
        if (evenements.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(evenements);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieve event by ID", notes = "This endpoint returns an event based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the event"),
            @ApiResponse(code = 404, message = "Event not found")
    })
    public ResponseEntity<EvenementDto> getEvenementById(@PathVariable("id") long id) {
        EvenementDto evenement = evenementService.getEvenementById(id);
        if (evenement == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(evenement);
    }

    @PostMapping
    @ApiOperation(value = "Create a new event", notes = "This endpoint allows to create a new event")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Event created successfully"),
            @ApiResponse(code = 400, message = "Invalid request data")
    })
    public ResponseEntity<Void> addEvenement(@Valid @RequestBody EvenementDto evenementDto) {
        evenementService.ajouterEvenement(evenementDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing event", notes = "This endpoint updates an existing event based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Event updated successfully"),
            @ApiResponse(code = 404, message = "Event not found")
    })
    public ResponseEntity<Void> updateEvenement(@PathVariable("id") long id, @Valid @RequestBody EvenementDto evenementDto) {
        EvenementDto existingEvenement = evenementService.getEvenementById(id);
        if (existingEvenement == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        evenementService.modifierEvenement(evenementDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an event", notes = "This endpoint allows to delete an event based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Event deleted successfully"),
            @ApiResponse(code = 404, message = "Event not found")
    })
    public ResponseEntity<Void> deleteEvenement(@PathVariable("id") long id) {
        EvenementDto existingEvenement = evenementService.getEvenementById(id);
        if (existingEvenement == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        evenementService.supprimerEvenement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/sessions")
    @ApiOperation(value = "Retrieve all sessions for an event", notes = "This endpoint returns all sessions for a specific event ordered by date and time")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved sessions"),
            @ApiResponse(code = 404, message = "No sessions found for this event")
    })
    public ResponseEntity<List<SessionDto>> getAllSessionsEventOrderedByDate(@PathVariable("id") long id) {
        List<SessionDto> sessions = evenementService.getAllSessionsEventOrderedByDate(id);
        if (sessions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(sessions);
    }
}
