package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.DelayData;
import com.vaadin.flow.function.SerializablePredicate;

import java.util.function.Predicate;

public class DelayDataGridFilters implements GridFilters<DelayData> {

    @Override
    public SerializablePredicate<DelayData> getFilters(String searchTerm) {
        return delayData -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(delayData.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getScheduledStartTime()), searchTerm) ||
                    matchesTerm(delayData.getDelayLimit(), searchTerm) ||
                    matchesTerm(delayData.getRemarks(), searchTerm) ||
                    matchesTerm(delayData.getTotal(), searchTerm) ||
                    anyMatches(delayData, e -> e.getReason().equals(searchTerm)) ||
                    anyMatches(delayData, e -> e.getDelayNumber().equals(searchTerm)) ||
                    anyMatches(delayData, e -> e.getRemark().equals(searchTerm));
        };
    }

    private static boolean anyMatches(DelayData delayData, Predicate<DelayData.DelayItem> predicate) {
        return delayData.getDelays().stream().anyMatch(predicate);
    }
}
