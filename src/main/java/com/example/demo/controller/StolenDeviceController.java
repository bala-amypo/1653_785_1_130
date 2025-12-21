package com.example.demo.controller;

import com.example.demo.service.StolenDeviceService;
import com.example.demo.entity.StolenDeviceReport;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
@Tag(name = "Stolen Devices")
public class StolenDeviceController {

    @Autowired
    private StolenDeviceService service;

    @PostMapping
    public StolenDeviceReport report(@RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerial(@PathVariable String serialNumber) {
        return service.getReportsBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping
    public List<StolenDeviceReport> getAll() {
        return service.getAllReports();
    }
}
