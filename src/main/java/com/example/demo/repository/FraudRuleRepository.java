package com.example.demo.repository;
import com.example.demo.model.FraudRule;
import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface FraudRuleRepository extends JpaRepository<FraudRule,Long> {
    Optional<FraudRule> findByRuleCode(String ruleCode);
    List<FraudRule> findByActiveTrue();
    FraudRule save(FraudRule rule);
}
