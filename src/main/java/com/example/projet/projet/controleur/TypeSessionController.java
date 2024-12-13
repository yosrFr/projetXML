package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.TypeSessionDto;
import com.example.projet.projet.service.TypeSessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typesession")
@Tag(name = "Type Session", description = "API for managing types of sessions")
@Validated
public class TypeSessionController {

    private final TypeSessionService typeSessionService;

    @Autowired
    public TypeSessionController(TypeSessionService typeSessionService) {
        this.typeSessionService = typeSessionService;
    }

    @Operation(summary = "Add a new type of session")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Type of session added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid type of session data provided")
    })
    @PostMapping
    public ResponseEntity<Void> ajouterTypeSession(@Valid @RequestBody TypeSessionDto typeSession) {
        try {
            typeSessionService.ajouterTypeSession(typeSession);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Get a type of session by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the type of session"),
            @ApiResponse(responseCode = "404", description = "Type of session not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TypeSessionDto> getTypeSessionById(@PathVariable long id) {
        TypeSessionDto typeSession = typeSessionService.getTypeSessionById(id);
        if (typeSession != null) {
            return ResponseEntity.ok(typeSession);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Update a type of session")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Type of session updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid type of session data provided")
    })
    @PutMapping
    public ResponseEntity<Void> modifierTypeSession(@Valid @RequestBody TypeSessionDto typeSession) {
        try {
            typeSessionService.modifierTypeSession(typeSession);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Delete a type of session")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Type of session deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Type of session not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerTypeSession(@PathVariable long id) {
        try {
            typeSessionService.supprimerTypeSession(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
