package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.TypeInscriptionDto;
import com.example.projet.projet.service.TypeInscriptionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-inscriptions")
public class TypeInscriptionController {

    private final TypeInscriptionService typeInscriptionService;

    @Autowired
    public TypeInscriptionController(TypeInscriptionService typeInscriptionService) {
        this.typeInscriptionService = typeInscriptionService;
    }

    @GetMapping
    @ApiOperation(value = "Retrieve all types of inscriptions", notes = "This endpoint returns a list of all types of inscriptions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all types of inscriptions"),
            @ApiResponse(code = 204, message = "No types of inscriptions found")
    })
    public ResponseEntity<List<TypeInscriptionDto>> getAllTypesInscription() {
        List<TypeInscriptionDto> types = typeInscriptionService.getAllTypesInscription();
        if (types.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieve a type of inscription by ID", notes = "This endpoint returns a specific type of inscription by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the type of inscription"),
            @ApiResponse(code = 404, message = "Type of inscription not found")
    })
    public ResponseEntity<TypeInscriptionDto> getTypeInscriptionById(@PathVariable long id) {
        TypeInscriptionDto type = typeInscriptionService.getTypeInscriptionById(id);
        if (type == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(type);
    }

    @PostMapping
    @ApiOperation(value = "Create a new type of inscription", notes = "This endpoint allows to create a new type of inscription")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Type of inscription created successfully"),
            @ApiResponse(code = 400, message = "Invalid request data")
    })
    public ResponseEntity<Void> addTypeInscription(@RequestBody TypeInscriptionDto typeInscriptionDto) {
        typeInscriptionService.ajouterTypeInscription(typeInscriptionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a type of inscription", notes = "This endpoint allows to update a type of inscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Type of inscription updated successfully"),
            @ApiResponse(code = 404, message = "Type of inscription not found")
    })
    public ResponseEntity<Void> updateTypeInscription(@PathVariable long id, @RequestBody TypeInscriptionDto typeInscriptionDto) {
        if (typeInscriptionService.getTypeInscriptionById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        typeInscriptionDto.setIdTypeInscription(id);
        typeInscriptionService.modifierTypeInscription(typeInscriptionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a type of inscription", notes = "This endpoint allows to delete a type of inscription by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Type of inscription deleted successfully"),
            @ApiResponse(code = 404, message = "Type of inscription not found")
    })
    public ResponseEntity<Void> deleteTypeInscription(@PathVariable long id) {
        if (typeInscriptionService.getTypeInscriptionById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        typeInscriptionService.supprimerTypeInscription(id);
        return ResponseEntity.ok().build();
    }
}
