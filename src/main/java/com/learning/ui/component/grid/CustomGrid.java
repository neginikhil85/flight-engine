package com.learning.ui.component.grid;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;

import java.util.Collection;
import java.util.List;

public class CustomGrid<T> extends Grid<T> {

    private final ColumnProviderFactory columnProviderFactory;
    private final ColumnProvider<T> columnProvider;

    public CustomGrid(Class<T> beanType, ColumnProviderFactory columnProviderFactory) {
        super(beanType, false);
        this.columnProviderFactory = columnProviderFactory;
        this.columnProvider = columnProvider(beanType);

        initializeGrid(beanType);
    }

    private ColumnProvider<T> columnProvider(Class<T> beanType) {
        return columnProviderFactory.getProvider(beanType);
    }

    private void initializeGrid(Class<T> beanType) {
        // Initialize columns based on the ColumnProvider
        columnProvider.getHeaderAndValueProviders()
                .forEach((header, valueProvider) -> addColumn(valueProvider)
                        .setHeader(header)
                        .setAutoWidth(true));

        // Add custom columns if provided
        List<ColumnProvider.CustomColumn<T>> customColumns = columnProvider.getCustomColumns(columnProviderFactory);
        customColumns.forEach(customColumn -> {
            addColumn(customColumn.getRenderer())
                    .setHeader(customColumn.getHeader())
                    .setAutoWidth(true);
        });

        // Common setup for all grids
        addThemeVariants(GridVariant.LUMO_COMPACT);
        addClassName("custom-grid");
    }

    public void updateItems(Collection<T> data) {
        super.setItems(data);
    }
}
