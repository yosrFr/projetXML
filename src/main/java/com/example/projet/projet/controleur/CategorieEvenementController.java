package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.CategorieEvenementDto;
import com.example.projet.projet.service.CategorieEvenementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorieevenement")
@Tag(name = "Catégorie Événement", description = "API for managing event categories")
public class CategorieEvenementController {

    private final CategorieEvenementService categorieEvenementService;

    public CategorieEvenementController(CategorieEvenementService categorieEvenementService) {
        this.categorieEvenementService = categorieEvenementService;
    }

    @Operation(summary = "Add a new event category")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Event category added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid event category data provided")
    })
    @PostMapping
    public ResponseEntity<Void> ajouterCategorieEvenement(@RequestBody CategorieEvenementDto category) {
        try {
            categorieEvenementService.ajouterCategorieEvenement(category);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Get an event category by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the event category"),
            @ApiResponse(responseCode = "404", description = "Event category not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategorieEvenementDto> getCategorieEvenementById(@PathVariable long id) {
        CategorieEvenementDto categorie = categorieEvenementService.getCategorieEvenementById(id);
        if (categorie != null) {
            return ResponseEntity.ok(categorie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Update an event category")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Event category updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid event category data provided")
    })
    @PutMapping
    public ResponseEntity<Void> modifierCategorieEvenement(@RequestBody CategorieEvenementDto categorieEvenement) {
        try {
            categorieEvenementService.modifierCategorieEvenement(categorieEvenement);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Delete an event category")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Event category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Event category not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCategorieEvenement(@PathVariable long id) {
        try {
            categorieEvenementService.supprimerCategorieEvenement(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Get all event categories")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all event categories"),
    })
    @GetMapping
    public ResponseEntity<List<CategorieEvenementDto>> getAllCategoriesEvenement() {
        List<CategorieEvenementDto> categories = categorieEvenementService.getAllCategoriesEvenement();
        return ResponseEntity.ok(categories);
    }
}
