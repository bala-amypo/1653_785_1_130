package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleCode;
    private String description;
    private String ruleType;
    private Boolean active;
    public String getRuleCode() {
    return ruleCode;
}

public void setRuleCode(String ruleCode) {
    this.ruleCode = ruleCode;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getRuleType() {
    return ruleType;
}

public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
}

public Boolean getActive() {
    return active;
}

public void setActive(Boolean active) {
    this.active = active;
}


    // getters and setters
}
