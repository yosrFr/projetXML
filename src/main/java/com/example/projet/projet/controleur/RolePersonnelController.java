package com.example.projet.projet.controleur;

import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import com.example.projet.projet.service.RolePersonnelService;
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
@RequestMapping("/api/roles-personnel")
@Tag(name = "RolePersonnel", description = "API for managing personnel roles")
@Validated
public class RolePersonnelController {

    private final RolePersonnelService rolePersonnelService;

    @Autowired
    public RolePersonnelController(RolePersonnelService rolePersonnelService) {
        this.rolePersonnelService = rolePersonnelService;
    }

    @Operation(summary = "Get all personnel roles")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of personnel roles"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<RolePersonnelDto>> getAllRolesPersonnel() {
        try {
            List<RolePersonnelDto> roles = rolePersonnelService.getAllRolesPersonnel();
            return ResponseEntity.ok(roles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get all personnel role names")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of personnel role names"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllRoleNames() {
        try {
            List<String> roleNames = rolePersonnelService.getALLNomsRolesPersonnel();
            return ResponseEntity.ok(roleNames);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get personnel role by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved personnel role"),
            @ApiResponse(responseCode = "404", description = "Personnel role not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<RolePersonnelDto> getRolePersonnelById(@PathVariable long id) {
        RolePersonnelDto role = rolePersonnelService.getRolePersonnelById(id);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(role);
    }

    @Operation(summary = "Add a new personnel role")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Personnel role created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    public ResponseEntity<Void> ajouterRolePersonnel(@Valid @RequestBody RolePersonnelDto rolePersonnelDto) {
        try {
            rolePersonnelService.ajouterRolePersonnel(rolePersonnelDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Update an existing personnel role")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Personnel role updated successfully"),
            @ApiResponse(responseCode = "404", description = "Personnel role not found")
    })
    @PutMapping
    public ResponseEntity<Void> modifierRolePersonnel(@Valid @RequestBody RolePersonnelDto rolePersonnelDto) {
        try {
            rolePersonnelService.modifierRolePerssonnel(rolePersonnelDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Delete a personnel role by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Personnel role deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Personnel role not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerRolePersonnel(@PathVariable long id) {
        try {
            rolePersonnelService.supprimerRolePersonnel(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

