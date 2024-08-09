package com.learning.ui.component.grid.provider.impl.delay;

import com.learning.ui.component.dialog.DelayDialog;
import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.model.DelayData;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class DelayDataColumnProvider implements ColumnProvider<DelayData> {

    @Value("${grid-column-provider.date-format}")
    private String pattern;

    @Override
    public Class<DelayData> beanType() {
        return DelayData.class;
    }

    @Override
    public Map<String, ValueProvider<DelayData, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", DelayData::getFlightNumber);
            put("Date Of Origin", DelayData::getDateOfOrigin);
            put("Start Station", DelayData::getStartStation);
            put("End Station", DelayData::getEndStation);
            put("Schedule Start Time", DelayData::getScheduleStartTime);
            put("Delay limit", DelayData::getDelayLimit);
            put("Delay Remarks", DelayData::getRemarks);
            put("Total Delays", DelayData::getTotal);
            put("Event Received On", getEventReceivedOn());
        }};
    }

    private ValueProvider<DelayData, Object> getEventReceivedOn() {
        return delayData -> delayData.getEventReceivedOn().format(DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public List<CustomColumn<DelayData>> getCustomColumns(ColumnProviderFactory factory) {
        return List.of(
                new CustomColumn<>("Delays", new ComponentRenderer<>(item -> {
                    Button viewBtn = new Button("view");
                    viewBtn.setIcon(VaadinIcon.EYE.create());
                    viewBtn.addClassNames("compact-button");
                    viewBtn.addClickListener(click -> {
                        DelayDialog dialog = new DelayDialog(item.getDelays(), factory);
                        dialog.addClassName("custom-dialog");
                        dialog.open();
                    });
                    return viewBtn;
                }))
        );
    }
}
