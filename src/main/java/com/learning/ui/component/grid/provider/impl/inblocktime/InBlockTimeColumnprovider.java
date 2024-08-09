package com.learning.ui.component.grid.provider.impl.inblocktime;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.InBlockTime;
import com.learning.ui.model.InBlockTime;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class InBlockTimeColumnprovider implements ColumnProvider<InBlockTime> {
    @Override
    public Class<InBlockTime> beanType() {
        return InBlockTime.class;
    }

    @Override
    public Map<String, ValueProvider<InBlockTime, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", InBlockTime::getFlightNumber);
            put("Carrier", InBlockTime::getCarrier);
            put("Date Of Origin", InBlockTime::getDateOfOrigin);
            put("Start Station", InBlockTime::getStartStation);
            put("End Station", InBlockTime::getEndStation);
            put("Schedule Start Time", InBlockTime::getScheduleStartTime);
            put("Estimated door close time",InBlockTime::getInBlockTime);
        }};
    }
}
