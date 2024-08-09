package com.learning.ui.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfo {
    private int flightNumber;
    private String carrier;
    private LocalDate dateOfOrigin;
    private String startStation;
    private String endStation;
    private String scheduleStartTime;
    private String doorCloseTime;
    private String divertedStation;
    private String diversionTime;
    private String diversionReason;
    private String EstimatedTime;
    private String ActualTime;
    private String Equipment;
    private String FlightCancel;
    private String FlightReturn;
    private String FlightDelete;
    private String Terminal;
    private String OperationStatus;
    private String GateChange;
    private String InBlockTime;
    private String OffBlockTime;
    private String LandingTime;
    private String TakeOffTime;


}
