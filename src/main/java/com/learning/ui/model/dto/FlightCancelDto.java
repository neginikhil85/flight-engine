package com.learning.ui.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightCancelDto {
    private String operationalStatus;
    private String cancellationCode;
    private String serviceType;
    private String flightStatus;
}
