package com.learning.ui.component.grid.filter.impl;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.model.grid.Terminal;
import com.vaadin.flow.function.SerializablePredicate;

public class TerminalDataGridFilters implements GridFilters<Terminal> {
    @Override
    public SerializablePredicate<Terminal> getFilters(String searchTerm) {
        return terminal -> {
            if (searchTerm.isBlank())
                return true;

            return matchesTerm(String.valueOf(terminal.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(terminal.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(terminal.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(terminal.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(terminal.getScheduledStartTime()), searchTerm);
        };
    }
}

