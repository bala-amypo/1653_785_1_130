package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.time.LocalDate;
import java.util.*;

public class WarrantyClaimServiceImpl {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository c,
            DeviceOwnershipRecordRepository d,
            StolenDeviceReportRepository s,
            FraudAlertRecordRepository a,
            FraudRuleRepository r) {
        this.claimRepo = c;
        this.deviceRepo = d;
        this.stolenRepo = s;
        this.alertRepo = a;
        this.ruleRepo = r;
    }

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        DeviceOwnershipRecord device =
                deviceRepo.findBySerialNumber(claim.getSerialNumber()).orElseThrow();

        if (claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason())
                || device.getWarrantyExpiration().isBefore(LocalDate.now())
                || stolenRepo.existsBySerialNumber(claim.getSerialNumber())) {
            claim.setStatus("FLAGGED");
        }
        return claimRepo.save(claim);
    }

    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord claim = claimRepo.findById(id).orElseThrow();
        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    public List<WarrantyClaimRecord> getClaimsBySerial(String serial) {
        return claimRepo.findBySerialNumber(serial);
    }

    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }
}
