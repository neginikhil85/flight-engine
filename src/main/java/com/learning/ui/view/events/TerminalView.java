package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.Terminal;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/terminal", layout = MainLayout.class)
public class TerminalView extends VerticalLayout {
    public TerminalView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Terminal");
        CustomGrid<Terminal> delayGrid = new CustomGrid<>(Terminal.class, columnProviderFactory);
        delayGrid.updateItems(getTerminalData());
        add(title, delayGrid);

    }

    private List<Terminal> getTerminalData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/terminal.json", new TypeReference<>() {
        });
    }
}
