package com.example.demo.repository;
import com.example.demo.model.StolenDeviceReport;
import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface StolenDeviceReportRepository extends JpaRepository<Long,> {
    boolean existsBySerialNumber(String serial);
    Optional<StolenDeviceReport> findById(Long id);
    List<StolenDeviceReport> findBySerialNumber(String serial);
    List<StolenDeviceReport> findAll();
    StolenDeviceReport save(StolenDeviceReport report);
}
