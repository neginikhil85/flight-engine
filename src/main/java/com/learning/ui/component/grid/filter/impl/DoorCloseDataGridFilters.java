package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.DoorClose;
import com.vaadin.flow.function.SerializablePredicate;

public class DoorCloseDataGridFilters implements GridFilters<DoorClose> {
    @Override
    public SerializablePredicate<DoorClose> getFilters(String searchTerm) {
        return doorClose -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(doorClose.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(doorClose.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(doorClose.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(doorClose.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(doorClose.getScheduledStartTime()), searchTerm);
        };
    }
}