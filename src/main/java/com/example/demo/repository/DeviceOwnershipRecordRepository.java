package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeviceOwnershipRecord;
import java.util.Optional;

public interface DeviceOwnershipRecordRepository
        extends JpaRepository<DeviceOwnershipRecord, Long> {

    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}
