package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Warranty Claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    // POST /api/claims
    @PostMapping
    public WarrantyClaimRecord submitClaim(
            @RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    // PUT /api/claims/{id}/status
    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateClaimStatus(id, status);
    }

    // GET /api/claims/serial/{serialNumber}
    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getBySerial(
            @PathVariable String serialNumber) {
        return service.getClaimsBySerial(serialNumber);
    }

    // GET /api/claims/{id}
    @GetMapping("/{id}")
    public Optional<WarrantyClaimRecord> getById(
            @PathVariable Long id) {
        return service.getClaimById(id);
    }

    // GET /api/claims
    @GetMapping
    public List<WarrantyClaimRecord> getAll() {
        return service.getAllClaims();
    }
}
