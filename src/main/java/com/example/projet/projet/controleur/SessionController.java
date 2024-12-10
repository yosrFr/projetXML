package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@Tag(name = "Session", description = "API for managing sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Operation(summary = "Add a new session")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Session added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid session data provided")
    })
    @PostMapping
    public ResponseEntity<Void> ajouterSession(@RequestBody SessionDto session) {
        try {
            sessionService.ajouterSession(session);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Get a session by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the session"),
            @ApiResponse(responseCode = "404", description = "Session not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<SessionDto> getSessionById(@PathVariable long id) {
        SessionDto session = sessionService.getSessionById(id);
        if (session != null) {
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Update a session")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Session updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid session data provided")
    })
    @PutMapping
    public ResponseEntity<Void> modifierSession(@RequestBody SessionDto session) {
        try {
            sessionService.modifierSession(session);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Delete a session")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Session deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Session not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerSession(@PathVariable long id) {
        try {
            sessionService.supprimerSession(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
