package com.example.demo.controller;

import com.example.demo.service.WarrantyClaimService;
import com.example.demo.entity.WarrantyClaimRecord;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    @Autowired
    private WarrantyClaimService service;

    @PostMapping
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }
}
