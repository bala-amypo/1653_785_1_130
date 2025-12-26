package com.example.demo.repository;

import com.example.demo.model.FraudRule;
import java.util.*;

public interface FraudRuleRepository {
    Optional<FraudRule> findByRuleCode(String ruleCode);
    List<FraudRule> findByActiveTrue();
    FraudRule save(FraudRule rule);
}
