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

    public FraudRule createRule(FraudRule rule) {
        return repo.save(rule);
    }

    public FraudRule updateRule(Long id, FraudRule rule) {
        FraudRule r = repo.findById(id).orElse(null);
        if (r != null) {
            r.setRuleCode(rule.getRuleCode());
            r.setDescription(rule.getDescription());
            r.setRuleType(rule.getRuleType());
            r.setActive(rule.getActive());
            return repo.save(r);
        }
        return null;
    }

    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public FraudRule getRuleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
