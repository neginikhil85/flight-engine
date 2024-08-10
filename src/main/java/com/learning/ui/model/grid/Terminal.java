package com.learning.ui.model.grid;

import com.learning.ui.model.dto.FlightInfoDto;
import com.learning.ui.model.dto.GateTerminalDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Terminal extends FlightInfoDto {
    private GateTerminalDto current;
    private GateTerminalDto previous;
}
