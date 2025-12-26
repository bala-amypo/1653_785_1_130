package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface FraudRuleRepository {
    Optional<FraudRule> findByRuleCode(String code);
    List<FraudRule> findByActiveTrue();
    List<FraudRule> findAll();
    FraudRule save(FraudRule r);
}
