package com.learning.ui.model.grid;

import com.learning.ui.model.dto.FlightCancelDto;
import com.learning.ui.model.dto.FlightInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class FlightCancel extends FlightInfoDto {
    private FlightCancelDto current;
    private FlightCancelDto previous;
}
