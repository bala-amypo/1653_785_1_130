package com.example.demo.service.impl;

import com.example.demo.service.WarrantyClaimService;
import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    @Autowired
    private WarrantyClaimRecordRepository repo;

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        return repo.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repo.findAll();
    }
}