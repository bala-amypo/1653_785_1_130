package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;

public class FraudRuleServiceImpl {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository repo) {
        this.repo = repo;
    }

    public FraudRule createRule(FraudRule r) {
        return repo.save(r);
    }

    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
