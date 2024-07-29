package com.learning.ui.view;

import com.learning.ui.component.card.CustomCard;
import com.learning.ui.component.card.FlightDataCard;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "/flight-inquiry", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class FlightInquiryView extends VerticalLayout {

    public FlightInquiryView(ColumnProviderFactory columnProviderFactory) {
        H1 title = new H1("Flight Inquiry");
        Button flightQueryBtn = new Button("New Flight Query", click -> add(openForm()));
        flightQueryBtn.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        CustomCard flightData = new FlightDataCard();
        add(title, flightQueryBtn, flightData);
    }

    private FormLayout openForm() {
        return new FormLayout() {{
            TextField carrier = new TextField("Carrier");
            TextField flightNumber = new TextField("Flight Number");
            TextField startTerminal = new TextField("Start Terminal");
            TextField endTerminal = new TextField("End Terminal");

            Button submit = new Button("submit", click -> getRemove(this));
            submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

            add(carrier, flightNumber, startTerminal, endTerminal, submit);

        }};
    }

    private void getRemove(FormLayout formLayout) {
        remove(formLayout);
    }
}
