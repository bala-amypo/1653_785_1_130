package com.example.demo.repository;

import com.example.demo.model.*;

public interface StolenDeviceReportRepository {
    boolean existsBySerialNumber(String s);
    StolenDeviceReport save(StolenDeviceReport r);
}
