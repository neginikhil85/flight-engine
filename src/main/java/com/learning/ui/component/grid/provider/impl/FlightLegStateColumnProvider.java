package com.learning.ui.component.grid.provider.impl;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.FlightLegState;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class FlightLegStateColumnProvider implements ColumnProvider<FlightLegState> {

    @Override
    public Class<FlightLegState> beanType() {
        return FlightLegState.class;
    }

    @Override
    public Map<String, ValueProvider<FlightLegState, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", FlightLegState::getFlightNumber);
            put("Carrier", FlightLegState::getCarrier);
            put("Date Of Origin", FlightLegState::getDateOfOrigin);
            put("Start Station", FlightLegState::getStartStation);
            put("End Station", FlightLegState::getEndStation);
            put("Schedule Start Time", FlightLegState::getScheduleStartTime);
            put("Start Terminal", FlightLegState::getStartTerminal);
            put("End Terminal", FlightLegState::getEndTerminal);
        }};
    }
}
