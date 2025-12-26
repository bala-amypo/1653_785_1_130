package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface FraudRuleRepository {
    List<FraudRule> findAll();
    FraudRule save(FraudRule r);
}
