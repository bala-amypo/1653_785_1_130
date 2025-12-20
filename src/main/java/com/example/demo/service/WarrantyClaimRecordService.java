package com.example.demo.service;

import com.example.demo.entity.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);

    List<WarrantyClaimRecord> getAllClaims();
}
