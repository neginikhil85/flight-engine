package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.DiversionData;
import com.vaadin.flow.function.SerializablePredicate;

public class DiversionDataGridFilters implements GridFilters<DiversionData> {
    @Override
    public SerializablePredicate<DiversionData> getFilters(String searchTerm) {
        return diversion -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(diversion.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(diversion.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(diversion.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(diversion.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(diversion.getScheduledStartTime()), searchTerm);
        };
    }


}

