package com.example.demo.service.impl;

import com.example.demo.service.StolenDeviceService;
import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    @Autowired
    private StolenDeviceReportRepository repo;

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return repo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repo.findAll();
    }
}
