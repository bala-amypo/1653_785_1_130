package com.example.demo.controller;

import com.example.demo.service.FraudAlertService;
import com.example.demo.entity.FraudAlertRecord;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    @Autowired
    private FraudAlertService service;

    @PostMapping
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }

    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return service.getAllAlerts();
    }
}
