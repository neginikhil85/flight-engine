package com.learning.ui.model.dto;

import com.learning.ui.model.grid.FlightLegState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto {
    private String plannedAircraftType;
    private FlightLegState.EquipmentData.AircraftInfo aircraft;
    private String aircraftConfiguration;
    private String assignedAircraftConfiguration;
}
