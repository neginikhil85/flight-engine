package com.learning.ui.model.grid;

import com.learning.ui.enums.TimeType;
import com.learning.ui.model.dto.FlightInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class LandingTime extends FlightInfoDto {
    private String currentLandingTime;
    private String previousLandingTime;
    private TimeType timeType;
}
