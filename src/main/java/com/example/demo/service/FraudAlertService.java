package com.example.demo.service;

import com.example.demo.entity.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord createAlert(FraudAlertRecord alert);

    List<FraudAlertRecord> getAllAlerts();
}
