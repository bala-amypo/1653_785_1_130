package com.example.demo.controller;

import com.example.demo.service.StolenDeviceService;
import com.example.demo.entity.StolenDeviceReport;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    @Autowired
    private StolenDeviceService service;

    @PostMapping
    public StolenDeviceReport reportStolen(@RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }
}
