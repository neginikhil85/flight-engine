package com.learning.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class HandlingData {
    private String serviceType;
    private String aircraftOwner;
    private String cockpitEmployer;
    private String cabinEmployer;
}
