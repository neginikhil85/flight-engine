package com.learning.ui.model.grid;

import com.learning.ui.model.dto.FlightInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class DoorClose extends FlightInfoDto {
    private FlightLegState.ActualTimes currentActualTimes;
    private FlightLegState.ActualTimes previousActualTimes;
}
