package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.GateChange;
import com.vaadin.flow.function.SerializablePredicate;

public class GateChangeDataGridFilters implements GridFilters<GateChange> {
    @Override
    public SerializablePredicate<GateChange> getFilters(String searchTerm) {
        return gateChange -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(gateChange.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(gateChange.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(gateChange.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(gateChange.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(gateChange.getScheduledStartTime()), searchTerm);
        };
    }
}

