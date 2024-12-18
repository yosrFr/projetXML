package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.service.PersonnelService;
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

import java.util.List;

@RestController
@RequestMapping("/api/personnel")
@Tag(name = "Personnel", description = "API for managing personnel")
@Validated
public class PersonnelController {

    private final PersonnelService personnelService;

    @Autowired
    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @Operation(summary = "Get all personnel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of personnel"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<PersonnelDto>> getAllPersonnel() {
        try {
            List<PersonnelDto> personnels = personnelService.getAllPersonnel();
            return ResponseEntity.ok(personnels);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get personnel by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved personnel"),
            @ApiResponse(responseCode = "404", description = "Personnel not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonnelDto> getPersonnelById(@PathVariable long id) {
        PersonnelDto personnel = personnelService.getPersonnelById(id);
        if (personnel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(personnel);
    }

    @Operation(summary = "Add new personnel")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Personnel created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    public ResponseEntity<Void> ajouterPersonnel(@Valid @RequestBody PersonnelDto personnelDto) {
        try {
            personnelService.ajouterPersonnel(personnelDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Update personnel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Personnel updated successfully"),
            @ApiResponse(responseCode = "404", description = "Personnel not found")
    })
    @PutMapping
    public ResponseEntity<Void> modifierPersonnel(@Valid @RequestBody PersonnelDto personnelDto) {
        try {
            personnelService.modifierPersonnel(personnelDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Delete personnel by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Personnel deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Personnel not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPersonnel(@PathVariable long id) {
        try {
            personnelService.supprimerPersonnel(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Get available personnel by role and time")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of available personnel"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/disponible")
    public ResponseEntity<List<String>> getAllNomsPersonnelDispoByRole(@RequestParam String role, @RequestParam String date, @RequestParam String tempsDeb, @RequestParam String tempsFin) {
        try {
            List<String> availablePersonnel = personnelService.getAllNomsPersonnelDispoByRole(role, date, tempsDeb, tempsFin);
            return ResponseEntity.ok(availablePersonnel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

