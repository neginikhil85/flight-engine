package com.learning.ui.component.grid.provider;

import com.vaadin.flow.function.ValueProvider;

import java.util.Map;

public interface ColumnProvider<T> {
    Class<T> beanType();
    Map<String, ValueProvider<T, ?>> getHeaderAndValueProviders();
}
