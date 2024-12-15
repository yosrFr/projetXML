package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.MaterielDto;
import com.example.projet.projet.service.MaterielService;
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
@RequestMapping("/api/materiels")
@Validated
public class MaterielController {
    private final MaterielService materielService;

    @Autowired
    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @GetMapping
    @ApiOperation(value = "Get all materials", notes = "Retrieve a list of all materials")
    @ApiResponse(code = 200, message = "List of materials retrieved successfully")
    public ResponseEntity<List<MaterielDto>> getAllMateriels() {
        List<MaterielDto> materiels = materielService.getAllMateriels();
        return ResponseEntity.ok(materiels);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get material by ID", notes = "Retrieve a material by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Material found"),
            @ApiResponse(code = 404, message = "Material not found")
    })
    public ResponseEntity<MaterielDto> getMaterielById(@PathVariable long id) {
        MaterielDto materiel = materielService.getMaterielById(id);
        if (materiel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(materiel);
    }

    @PostMapping
    @ApiOperation(value = "Add a new material", notes = "This endpoint allows to add a new material")
    @ApiResponse(code = 201, message = "Material added successfully")
    public ResponseEntity<Void> ajouterMateriel(@Valid @RequestBody MaterielDto materielDto) {
        materielService.ajouterMateriel(materielDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a material", notes = "This endpoint allows to update a material")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Material updated successfully"),
            @ApiResponse(code = 404, message = "Material not found")
    })
    public ResponseEntity<Void> modifierMateriel(@PathVariable long id, @Valid @RequestBody MaterielDto materielDto) {
        MaterielDto existingMateriel = materielService.getMaterielById(id);
        if (existingMateriel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        materielDto.setIdMateriel(id);
        materielService.modifierMateriel(materielDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a material", notes = "This endpoint allows to delete a material")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Material deleted successfully"),
            @ApiResponse(code = 404, message = "Material not found")
    })
    public ResponseEntity<Void> supprimerMateriel(@PathVariable long id) {
        MaterielDto materiel = materielService.getMaterielById(id);
        if (materiel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        materielService.supprimerMateriel(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/disponibles")
    @ApiOperation(value = "Get available materials", notes = "Retrieve a list of available materials for a specific date and time range")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of available materials retrieved successfully"),
            @ApiResponse(code = 400, message = "Invalid request parameters")
    })
    public ResponseEntity<List<String>> getNomMaterielsDispo(@RequestParam String tempsDebut, @RequestParam String tempsFin, @RequestParam String date) {
        if (tempsDebut == null || tempsFin == null || date == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<String> nomsMaterielsDispo = materielService.getAllNomsMaterielsDispo(tempsDebut, tempsFin, date);
        return ResponseEntity.ok(nomsMaterielsDispo);
    }
}
