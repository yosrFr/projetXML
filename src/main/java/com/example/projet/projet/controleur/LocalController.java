package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.LocalDto;
import com.example.projet.projet.service.LocalService;
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
@RequestMapping("/api/locaux")
@Validated
public class LocalController {
    private final LocalService localService;

    @Autowired
    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @GetMapping
    @ApiOperation(value = "Get all local names", notes = "This endpoint allows to retrieve all local names")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved local names")
    })
    public ResponseEntity<List<String>> getAllNomsLocals() {
        return ResponseEntity.ok(localService.getAllNomsLocals());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a local by ID", notes = "This endpoint allows to retrieve a local by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the local"),
            @ApiResponse(code = 404, message = "Local not found")
    })
    public ResponseEntity<LocalDto> getLocalById(@PathVariable long id) {
        LocalDto local = localService.getLocalById(id);
        if (local != null) {
            return ResponseEntity.ok(local);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    @ApiOperation(value = "Add a new local", notes = "This endpoint allows to add a new local")
    @ApiResponse(code = 201, message = "Local added successfully")
    public ResponseEntity<Void> ajouterLocal(@Valid @RequestBody LocalDto localDto) {
        localService.ajouterLocal(localDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a local", notes = "This endpoint allows to update a local")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Local updated successfully"),
            @ApiResponse(code = 404, message = "Local not found")
    })
    public ResponseEntity<Void> modifierLocal(@PathVariable long id, @Valid @RequestBody LocalDto localDto) {
        LocalDto existingLocal = localService.getLocalById(id);
        if (existingLocal != null) {
            localDto.setIdLocal(id);
            localService.modifierLocal(localDto);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a local", notes = "This endpoint allows to delete a local by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Local deleted successfully"),
            @ApiResponse(code = 404, message = "Local not found")
    })
    public ResponseEntity<Void> supprimerLocal(@PathVariable long id) {
        LocalDto local = localService.getLocalById(id);
        if (local != null) {
            localService.supprimerLocal(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
