package com.example.demo.controller;

import com.example.demo.service.FraudRuleService;
import com.example.demo.entity.FraudRule;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
@Tag(name = "Fraud Rules")
public class FraudRuleController {

    @Autowired
    private FraudRuleService service;

    @PostMapping
    public FraudRule create(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public FraudRule update(@PathVariable Long id, @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<FraudRule> getActive() {
        return service.getActiveRules();
    }

    @GetMapping("/{id}")
    public FraudRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping
    public List<FraudRule> getAll() {
        return service.getAllRules();
    }
}
