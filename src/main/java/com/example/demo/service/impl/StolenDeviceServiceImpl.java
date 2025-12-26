package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;

public class StolenDeviceServiceImpl {

    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository s,
                                   DeviceOwnershipRecordRepository d) {
        this.stolenRepo = s;
        this.deviceRepo = d;
    }

    public StolenDeviceReport reportStolen(StolenDeviceReport r) {
        deviceRepo.findBySerialNumber(r.getSerialNumber())
                .orElseThrow(NoSuchElementException::new);
        return stolenRepo.save(r);
    }
}
