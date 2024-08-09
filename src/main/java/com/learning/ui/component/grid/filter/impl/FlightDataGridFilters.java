package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.FlightLegState;
import com.vaadin.flow.function.SerializablePredicate;

public class FlightDataGridFilters implements GridFilters<FlightLegState> {

    @Override
    public SerializablePredicate<FlightLegState> getFilters(String searchTerm) {
        return flightLegState -> {
            if (searchTerm.isBlank())
                return true;
            return matchesTerm(String.valueOf(flightLegState.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(flightLegState.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(flightLegState.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(flightLegState.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(flightLegState.getScheduleStartTime()), searchTerm) ||
                    matchesTerm(String.valueOf(flightLegState.getStartTerminal()), searchTerm) ||
                    matchesTerm(String.valueOf(flightLegState.getEndTerminal()), searchTerm);
        };
    }

    private boolean matchesTerm(String value, String searchTerm) {
        return value.toLowerCase().contains(searchTerm.toLowerCase());
    }
}
