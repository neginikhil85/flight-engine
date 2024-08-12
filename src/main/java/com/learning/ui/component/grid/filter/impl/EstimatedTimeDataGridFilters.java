package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.EstimatedTime;
import com.vaadin.flow.function.SerializablePredicate;

public class EstimatedTimeDataGridFilters implements GridFilters<EstimatedTime> {
    @Override
    public SerializablePredicate<EstimatedTime> getFilters(String searchTerm) {
        return estimatedTime -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(estimatedTime.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(estimatedTime.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(estimatedTime.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(estimatedTime.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(estimatedTime.getScheduledStartTime()), searchTerm);
        };
    }
}