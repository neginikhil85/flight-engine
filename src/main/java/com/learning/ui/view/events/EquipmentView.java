package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.grid.Equipment;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/equipment", layout = MainLayout.class)
public class EquipmentView extends VerticalLayout {
    public EquipmentView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Equipment");
        CustomGrid<Equipment> delayGrid = new CustomGrid<>(Equipment.class, columnProviderFactory);
        delayGrid.updateItems(getEquipmentData());
        add(title, delayGrid);

    }

    private List<Equipment> getEquipmentData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/equipment.json", new TypeReference<>() {
        });
    }
}
