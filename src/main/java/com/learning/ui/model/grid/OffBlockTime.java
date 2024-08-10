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
public class OffBlockTime extends FlightInfoDto {
    private String currentOffBlock;
    private String previousOffBlock;
    private TimeType timeType;
}