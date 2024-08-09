package com.learning.ui.component.grid.filter;

import com.vaadin.flow.function.SerializablePredicate;

public interface GridFilters<T> {

    SerializablePredicate<T> getFilters(String searchTerm);
}
