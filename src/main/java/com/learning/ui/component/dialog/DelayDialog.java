package com.learning.ui.component.dialog;

import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.model.DelayData;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.List;

public class DelayDialog extends Dialog {

    CustomGrid<DelayData.DelayItem> nestedGrid;

    public DelayDialog(List<DelayData.DelayItem> delayItems, ColumnProviderFactory factory) {
        setDraggable(true);

        Div headerTitle = new Div();
        headerTitle.setText("Delays");
        headerTitle.addClassName("dialog-title");

        Button closeBtn = new Button();
        closeBtn.addClickListener(click -> this.close());
        closeBtn.addClassName("dialog-close-btn");
        closeBtn.setIcon(VaadinIcon.CLOSE.create());

        HorizontalLayout headerLayout = new HorizontalLayout(headerTitle, closeBtn);
        headerLayout.addClassName("dialog-header");
        headerLayout.setWidthFull();

        // Create a nested grid to show delay items
        nestedGrid = new CustomGrid<>(DelayData.DelayItem.class, factory);
        nestedGrid.addClassName("nested-custom-grid");
        nestedGrid.setItems(delayItems);

        // Add the grid to the dialog
        add(headerLayout, nestedGrid);
    }
}