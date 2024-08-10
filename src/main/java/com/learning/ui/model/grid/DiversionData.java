package com.learning.ui.model.grid;

import com.learning.ui.model.dto.FlightInfoDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class DiversionData extends FlightInfoDto {
    private String flightStatus;
    private String effectiveArrivalStation;
    private String diversionCode;
    private String estimatedInBlock;
    private String registration;
    private FlightLegState.FlightContinuationDataDto continuationLeg;
}
