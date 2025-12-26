package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;

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

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord c) {
        DeviceOwnershipRecord d = deviceRepo.findBySerialNumber(c.getSerialNumber())
                .orElseThrow(NoSuchElementException::new);

        boolean flag = false;

        if (claimRepo.existsBySerialNumberAndClaimReason(c.getSerialNumber(), c.getClaimReason()))
            flag = true;

        if (d.getWarrantyExpiration() != null &&
            d.getWarrantyExpiration().isBefore(LocalDate.now()))
            flag = true;

        if (stolenRepo.existsBySerialNumber(c.getSerialNumber()))
            flag = true;

        if (flag) c.setStatus("FLAGGED");
        return claimRepo.save(c);
    }

    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord c = claimRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);
        c.setStatus(status);
        return claimRepo.save(c);
    }

    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }

    public List<WarrantyClaimRecord> getClaimsBySerial(String serial) {
        return claimRepo.findBySerialNumber(serial);
    }
}
