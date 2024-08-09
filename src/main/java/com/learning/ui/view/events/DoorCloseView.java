package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.DoorClose;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "/flight-door-close", layout = MainLayout.class)
public class DoorCloseView extends VerticalLayout {

    public DoorCloseView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Door Close");
        CustomGrid<DoorClose> delayGrid = new CustomGrid<>(DoorClose.class, columnProviderFactory);
        delayGrid.updateItems(getDoorCloseData());
        add(title, delayGrid);

    }

    private List<DoorClose> getDoorCloseData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/door_close.json", new TypeReference<>() {
        });

    }


}
