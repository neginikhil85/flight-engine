package com.learning.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfo {
    private int flightNumber;
    private String carrier;
    private LocalDate dateOfOrigin;
    private String startTerminal;
    private String endTerminal;
    private String scheduleStartTime;
}
