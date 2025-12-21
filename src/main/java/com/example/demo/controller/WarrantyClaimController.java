package com.example.demo.controller;

import com.example.demo.service.WarrantyClaimService;
import com.example.demo.entity.WarrantyClaimRecord;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Warranty Claims")
public class WarrantyClaimController {

    @Autowired
    private WarrantyClaimService service;

    @PostMapping
    public WarrantyClaimRecord submit(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        service.updateClaimStatus(id, status);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getClaimsBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAll() {
        return service.getAllClaims();
    }
}
