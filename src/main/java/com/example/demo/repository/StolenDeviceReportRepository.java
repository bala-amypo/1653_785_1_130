package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StolenDeviceReport;
import java.util.List;

public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReport, Long> {

    List<StolenDeviceReport> findBySerialNumber(String serialNumber);
}
