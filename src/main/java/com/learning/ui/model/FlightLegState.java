package com.learning.ui.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FlightLegState extends FlightInfo {
    private String operationalStatus;
    private String flightStatus;
    private String cancellationCode;
    private String startTerminal;
    private String endTerminal;
    private String startGate;
    private String endGate;
    private String startStand;
    private String endStand;
    private String startTimeOffset;
    private String endTimeOffset;
    private HandlingData handlingData;
}
