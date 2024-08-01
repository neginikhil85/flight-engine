package com.learning.ui.component.grid.provider.impl.delay;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.DelayData;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class DelayItemColumnProvider implements ColumnProvider<DelayData.DelayItem> {

    @Override
    public Class<DelayData.DelayItem> beanType() {
        return DelayData.DelayItem.class;
    }

    @Override
    public Map<String, ValueProvider<DelayData.DelayItem, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Time", DelayData.DelayItem::getTime);
            put("Reason", DelayData.DelayItem::getReason);
            put("Delay Number", DelayData.DelayItem::getDelayNumber);
            put("Is Root Cause", DelayData.DelayItem::isRootCause);
            put("Remark", DelayData.DelayItem::getRemark);
        }};
    }
}