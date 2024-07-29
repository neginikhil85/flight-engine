package com.learning.ui.component.grid;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.vaadin.flow.component.grid.Grid;

public class CustomGrid<T> extends Grid<T> {

    private final ColumnProviderFactory columnProviderFactory;

    public CustomGrid(Class<T> beanType, ColumnProviderFactory columnProviderFactory) {
        super(beanType, false);
        this.columnProviderFactory = columnProviderFactory;// Add custom style name
        columnProvider(beanType)
                .getHeaderAndValueProviders()
                .forEach((header, valueProvider) -> addColumn(valueProvider)
                                                        .setHeader(header)
                                                        .setAutoWidth(true));

        addClassName("custom-grid");
    }

    private ColumnProvider<T> columnProvider(Class<T> beanType) {
        return columnProviderFactory.getProvider(beanType);
    }
}
