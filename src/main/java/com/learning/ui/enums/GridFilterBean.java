package com.learning.ui.enums;

import com.learning.ui.component.grid.filter.GridFilters;
import com.learning.ui.component.grid.filter.impl.DelayDataGridFilters;
import com.learning.ui.component.grid.filter.impl.DiversionDataGridFilters;
import com.learning.ui.component.grid.filter.impl.DoorCloseDataGridFilters;
import com.learning.ui.component.grid.filter.impl.FlightDataGridFilters;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

@Getter
public enum GridFilterBean {
    FLIGHT_DATA(FlightDataGridFilters::new),
    DELAY_DATA(DelayDataGridFilters::new),
    DIVERSION_DATA(DiversionDataGridFilters::new),
    DOOR_CLOSE(DoorCloseDataGridFilters::new);

    private final GridFilters<?> bean;
    private final SingletonHelper singletonHelper = new SingletonHelper();

    // Constructor takes a supplier to ensure lazy initialization
    <T> GridFilterBean(Supplier<GridFilters<T>> supplier) {
        this.bean = singletonHelper.initialize(supplier);
    }

    @SuppressWarnings("unchecked")
    public <T> GridFilters<T> getBean() {
        return (GridFilters<T>) bean;
    }

    private static class SingletonHelper {
        // Updated the map to use GridFilters<?> instead of Object
        private final Map<Supplier<? extends GridFilters<?>>, GridFilters<?>> instanceMap = new ConcurrentHashMap<>();

        private <T> GridFilters<T> initialize(Supplier<GridFilters<T>> supplier) {
            // Type-safe handling of instances in the map
            return (GridFilters<T>) instanceMap.computeIfAbsent(supplier, Supplier::get);
        }
    }
}
