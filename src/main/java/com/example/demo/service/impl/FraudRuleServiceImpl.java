package com.example.demo.service.impl;

import com.example.demo.service.FraudRuleService;
import com.example.demo.entity.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    @Autowired
    private FraudRuleRepository repo;

    @Override
    public FraudRule createRule(FraudRule rule) {
        return repo.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
