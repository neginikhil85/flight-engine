package com.learning.ui.component.grid.provider.impl.terminal;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.grid.Terminal;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class TerminalColumnProvider implements ColumnProvider<Terminal> {
    @Override
    public Class<Terminal> beanType() {
        return Terminal.class;
    }

    @Override
    public Map<String, ValueProvider<Terminal, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", Terminal::getFlightNumber);
            put("Carrier", Terminal::getCarrier);
            put("Date Of Origin", Terminal::getDateOfOrigin);
            put("Start Station", Terminal::getStartStation);
            put("End Station", Terminal::getEndStation);
            put("Scheduled Start Time", Terminal::getScheduledStartTime);
        }};
    }
}
