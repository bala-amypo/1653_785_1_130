package com.example.demo.model;
import lombok.*;
import jakarta.persistence.Entity;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StolenDeviceReport {
    private Long id;
    private String serialNumber;
}
