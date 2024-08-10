package com.learning.ui.component.grid.provider.impl;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.grid.FlightLegState;
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
            put("Date Of Origin", FlightLegState::getDateOfOrigin);
            put("Start Station", FlightLegState::getStartStation);
            put("End Station", FlightLegState::getEndStation);
            put("Scheduled Start Time", FlightLegState::getScheduledStartTime);
            put("Start Terminal", FlightLegState::getStartTerminal);
            put("End Terminal", FlightLegState::getEndTerminal);
            put("Operational Status", FlightLegState::getOperationalStatus);
            put("Flight Status", FlightLegState::getFlightStatus);
            put("Cancellation Code", FlightLegState::getCancellationCode);
            put("Start Gate", FlightLegState::getStartGate);
            put("End Gate", FlightLegState::getEndGate);
            put("Start Stand", FlightLegState::getStartStand);
            put("End Stand", FlightLegState::getEndStand);
            put("StartTime Offset", FlightLegState::getStartTimeOffset);
            put("EndTime Offset", FlightLegState::getEndTimeOffset);
            put("Service Type", safeValueProvider(flightLegState -> flightLegState.getHandlingData().getServiceType()));
            put("Aircraft Owner", safeValueProvider(flightLegState -> flightLegState.getHandlingData().getAircraftOwner()));
            put("Cabin Employer", safeValueProvider(flightLegState -> flightLegState.getHandlingData().getCabinEmployer()));
            put("Cockpit Employer", safeValueProvider(flightLegState -> flightLegState.getHandlingData().getCockpitEmployer()));
        }};
    }
}
