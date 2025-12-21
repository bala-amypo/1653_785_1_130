package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private String serialNumber;
    private String alertType;
    private String severity;
    private String message;
    private Boolean resolved = false;
    private LocalDateTime alertDate = LocalDateTime.now();

    // getters and setters
    public Boolean getResolved() {
    return resolved;
}

public void setResolved(Boolean resolved) {
    this.resolved = resolved;
}

}
