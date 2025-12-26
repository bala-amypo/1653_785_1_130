package com.example.demo.config;

import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    // ---------------- Device Ownership ----------------
    @Bean
    public DeviceOwnershipService deviceOwnershipService(
            DeviceOwnershipRecordRepository deviceRepo) {

        return new DeviceOwnershipServiceImpl(deviceRepo);
    }

    // ---------------- Warranty Claim ----------------
    @Bean
    public WarrantyClaimService warrantyClaimService(
            WarrantyClaimRecordRepository claimRepo,
            DeviceOwnershipRecordRepository deviceRepo,
            StolenDeviceReportRepository stolenRepo,
            FraudAlertRecordRepository alertRepo,
            FraudRuleRepository ruleRepo) {

        return new WarrantyClaimServiceImpl(
                claimRepo, deviceRepo, stolenRepo, alertRepo, ruleRepo);
    }

    // ---------------- Stolen Device ----------------
    @Bean
    public StolenDeviceService stolenDeviceService(
            StolenDeviceReportRepository stolenRepo,
            DeviceOwnershipRecordRepository deviceRepo) {

        return new StolenDeviceServiceImpl(stolenRepo, deviceRepo);
    }

    // ---------------- Fraud Rule ----------------
    @Bean
    public FraudRuleService fraudRuleService(
            FraudRuleRepository ruleRepo) {

        return new FraudRuleServiceImpl(ruleRepo);
    }

    // ---------------- Fraud Alert ----------------
    @Bean
    public FraudAlertService fraudAlertService(
            FraudAlertRecordRepository alertRepo) {

        return new FraudAlertServiceImpl(alertRepo);
    }
}
