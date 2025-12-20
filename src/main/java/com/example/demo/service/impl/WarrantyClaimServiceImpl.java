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

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        return repo.save(claim);
    }

    public void updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord c = repo.findById(id).orElse(null);
        if (c != null) {
            c.setStatus(status);
            repo.save(c);
        }
    }

    public WarrantyClaimRecord getClaimById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    public List<WarrantyClaimRecord> getAllClaims() {
        return repo.findAll();
    }
}
