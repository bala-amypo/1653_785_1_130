package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import java.util.*;

public class FraudRuleServiceImpl {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository repo) {
        this.repo = repo;
    }

    public FraudRule createRule(FraudRule rule) {
        if (repo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Duplicate rule");
        }
        return repo.save(rule);
    }

    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public Optional<FraudRule> getRuleByCode(String code) {
        return repo.findByRuleCode(code);
    }
}
