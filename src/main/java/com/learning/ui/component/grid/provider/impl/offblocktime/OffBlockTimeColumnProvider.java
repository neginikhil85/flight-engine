package com.learning.ui.component.grid.provider.impl.offblocktime;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.OffBlockTime;
import com.learning.ui.model.OffBlockTime;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class OffBlockTimeColumnProvider implements ColumnProvider<OffBlockTime> {
    @Override
    public Class<OffBlockTime> beanType() {
        return OffBlockTime.class;
    }

    @Override
    public Map<String, ValueProvider<OffBlockTime, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", OffBlockTime::getFlightNumber);
            put("Carrier", OffBlockTime::getCarrier);
            put("Date Of Origin", OffBlockTime::getDateOfOrigin);
            put("Start Station", OffBlockTime::getStartStation);
            put("End Station", OffBlockTime::getEndStation);
            put("Schedule Start Time", OffBlockTime::getScheduleStartTime);
            put("Estimated door close time",OffBlockTime::getOffBlockTime);
        }};
    }
}
