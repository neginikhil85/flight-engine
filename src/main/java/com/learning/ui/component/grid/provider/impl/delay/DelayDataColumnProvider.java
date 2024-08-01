package com.learning.ui.component.grid.provider.impl.delay;

import com.learning.ui.component.dialog.DelayDialog;
import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.model.DelayData;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class DelayDataColumnProvider implements ColumnProvider<DelayData> {

    @Override
    public Class<DelayData> beanType() {
        return DelayData.class;
    }

    @Override
    public Map<String, ValueProvider<DelayData, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", DelayData::getFlightNumber);
            put("Carrier", DelayData::getCarrier);
            put("Date Of Origin", DelayData::getDateOfOrigin);
            put("Start Station", DelayData::getStartStation);
            put("End Station", DelayData::getEndStation);
            put("Schedule Start Time", DelayData::getScheduleStartTime);
            put("Delay limit", DelayData::getDelayLimit);
            put("Delay Remarks", DelayData::getRemarks);
            put("Total Delays", DelayData::getTotal);
        }};
    }

    @Override
    public List<CustomColumn<DelayData>> getCustomColumns(ColumnProviderFactory factory) {
        return List.of(
                new CustomColumn<>("Show Delays", new ComponentRenderer<>(item -> {
                    Button viewBtn = new Button("view");
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
