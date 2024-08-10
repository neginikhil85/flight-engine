package com.learning.ui.component.grid.provider.impl.equipment;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.grid.Equipment;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class EquipmentColumnProvider implements ColumnProvider<Equipment> {
    @Override
    public Class<Equipment> beanType() {
        return Equipment.class;
    }

    @Override
    public Map<String, ValueProvider<Equipment, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", Equipment::getFlightNumber);
       //     put("Carrier", Equipment::getCarrier);
            put("Date Of Origin", Equipment::getDateOfOrigin);
            put("Start Station", Equipment::getStartStation);
            put("End Station", Equipment::getEndStation);
            put("Scheduled Start Time", Equipment::getScheduledStartTime);
        }};
    }
}
