package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.FlightCancel;
import com.vaadin.flow.function.SerializablePredicate;

public class FlightCancelDataGridFilters implements GridFilters<FlightCancel> {
    @Override
    public SerializablePredicate<FlightCancel> getFilters(String searchTerm) {
        return flightCancel -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(flightCancel.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(flightCancel.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(flightCancel.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(flightCancel.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(flightCancel.getScheduledStartTime()), searchTerm);
        };
    }
}
