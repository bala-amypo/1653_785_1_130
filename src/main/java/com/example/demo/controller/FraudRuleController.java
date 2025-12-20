package com.example.demo.controller;

import com.example.demo.service.FraudRuleService;
import com.example.demo.entity.FraudRule;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    @Autowired
    private FraudRuleService service;

    @PostMapping
    public FraudRule addRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }
}
