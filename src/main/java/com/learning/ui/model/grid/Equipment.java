package com.learning.ui.model.grid;

import com.learning.ui.model.dto.EquipmentDto;
import com.learning.ui.model.dto.FlightInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Equipment extends FlightInfoDto {
    private EquipmentDto current;
    private EquipmentDto previous;
}
