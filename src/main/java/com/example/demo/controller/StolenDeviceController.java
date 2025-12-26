package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stolen-devices")
@Tag(name = "Stolen Devices")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    // POST /api/stolen-devices
    @PostMapping
    public StolenDeviceReport reportStolen(
            @RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    // GET /api/stolen-devices/serial/{serialNumber}
    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerial(
            @PathVariable String serialNumber) {
        return service.getReportsBySerial(serialNumber);
    }

    // GET /api/stolen-devices/{id}
    @GetMapping("/{id}")
    public Optional<StolenDeviceReport> getById(
            @PathVariable Long id) {
        return service.getAllReports()
                .stream()
                .filter(r -> id.equals(r.getId()))
                .findFirst();
    }

    // GET /api/stolen-devices
    @GetMapping
    public List<StolenDeviceReport> getAll() {
        return service.getAllReports();
    }
}
