package com.example.demo.model;
import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.Entity;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceOwnershipRecord {
    private Long id;
    private String serialNumber;
    private String ownerName;
    private String ownerEmail;
    private LocalDate warrantyExpiration;
    private Boolean active;
}
