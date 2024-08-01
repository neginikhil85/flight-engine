package com.learning.ui.component.dialog;

import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.model.DelayData;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class DelayDialog extends Dialog {

    CustomGrid<DelayData.DelayItem> nestedGrid;

    public DelayDialog(List<DelayData.DelayItem> delayItems, ColumnProviderFactory factory) {
        setHeaderTitle("Delays");

        // Create a nested grid to show delay items
        nestedGrid = new CustomGrid<>(DelayData.DelayItem.class, factory);
        nestedGrid.addClassName("nested-custom-grid");
        nestedGrid.setItems(delayItems);

        // Add the grid to the dialog
        add(nestedGrid);
    }
}