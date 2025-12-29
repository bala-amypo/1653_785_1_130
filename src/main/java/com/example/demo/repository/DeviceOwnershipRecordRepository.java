package com.example.demo.repository;
import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.stereotype.Repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord,Long>{
    boolean existsBySerialNumber(String serialNumber);
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
    Optional<DeviceOwnershipRecord> findById(Long id);
    List<DeviceOwnershipRecord> findAll();
    DeviceOwnershipRecord save(DeviceOwnershipRecord record);
}
