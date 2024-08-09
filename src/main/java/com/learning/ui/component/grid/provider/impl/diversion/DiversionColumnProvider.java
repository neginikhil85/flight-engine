package com.learning.ui.component.grid.provider.impl.diversion;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.DiversionData;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class DiversionColumnProvider implements ColumnProvider<DiversionData> {
    @Override
    public Class<DiversionData> beanType() {
        return DiversionData.class;
    }

    @Override
    public Map<String, ValueProvider<DiversionData, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", DiversionData::getFlightNumber);
            put("Carrier", DiversionData::getCarrier);
            put("Date Of Origin", DiversionData::getDateOfOrigin);
            put("Start Station", DiversionData::getStartStation);
            put("End Station", DiversionData::getEndStation);
            put("Schedule Start Time", DiversionData::getScheduleStartTime);
            put("diverted Station Name", DiversionData::getDivertedStation);
            put("diversion Time", DiversionData::getDiversionTime);
            put("diversion Reason", DiversionData::getDiversionReason);

        }};
    }
}
