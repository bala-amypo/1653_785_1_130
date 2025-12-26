package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.*;
import java.util.*;

public class StolenDeviceServiceImpl {

    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository s,
                                   DeviceOwnershipRecordRepository d) {
        this.stolenRepo = s;
        this.deviceRepo = d;
    }

    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        deviceRepo.findBySerialNumber(report.getSerialNumber()).orElseThrow();
        return stolenRepo.save(report);
    }

    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return stolenRepo.findBySerialNumber(serial);
    }

    public List<StolenDeviceReport> getAllReports() {
        return stolenRepo.findAll();
    }
}
