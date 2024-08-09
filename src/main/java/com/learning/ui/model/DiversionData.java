package com.learning.ui.model;

import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
//@AllArgsConstructor
@NoArgsConstructor
public class DiversionData extends FlightInfo {
    private String flightStatus;
    private String effectiveArrivalStation;
    private String diversionCode;
    private String estimatedInBlock;
    private String registration;
    private FlightContinuationData continuationLeg;
}
