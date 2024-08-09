package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.OperationStatus;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/operation-status", layout = MainLayout.class)
public class OperationStatusView extends VerticalLayout {
    public OperationStatusView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Operation Status");
        CustomGrid<OperationStatus> delayGrid = new CustomGrid<>(OperationStatus.class, columnProviderFactory);
        delayGrid.updateItems(getOperationStatusData());
        add(title, delayGrid);

    }

    private List<OperationStatus> getOperationStatusData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/operation_status.json", new TypeReference<>() {
        });
    }
}
