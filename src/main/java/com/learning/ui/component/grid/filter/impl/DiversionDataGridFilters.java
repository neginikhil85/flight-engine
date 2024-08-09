package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.DelayData;
import com.learning.ui.model.DiversionData;
import com.vaadin.flow.function.SerializablePredicate;

import java.util.function.Predicate;

public class DiversionDataGridFilters implements GridFilters<DiversionData> {
    @Override
    public SerializablePredicate<DiversionData> getFilters(String searchTerm) {
        return delayData -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(delayData.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getScheduleStartTime()), searchTerm);
        };
    }
    private boolean matchesTerm(String value, String searchTerm) {
        return value.toLowerCase().contains(searchTerm.toLowerCase());
    }
}

