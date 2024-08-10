package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.FlightReturn;
import com.vaadin.flow.function.SerializablePredicate;

public class FlightReturnDataGridFilters implements GridFilters<FlightReturn> {
    @Override
    public SerializablePredicate<FlightReturn> getFilters(String searchTerm) {
        return flightReturn -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(flightReturn.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(flightReturn.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(flightReturn.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(flightReturn.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(flightReturn.getScheduledStartTime()), searchTerm);
        };
    }
    }
