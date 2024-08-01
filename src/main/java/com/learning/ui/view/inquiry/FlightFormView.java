package com.learning.ui.view.inquiry;

import com.learning.ui.component.form.FlightForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FlightFormView extends VerticalLayout {

    private FlightForm flightForm;
    private Button queryBtn;

    public FlightFormView() {
        addClassName("form-view");

        Div title = new Div("New Flight Query");
        title.setClassName("form-view-title");

        flightForm = new FlightForm();
        queryBtn = new Button("Query");

        add(title, flightForm, queryBtn);
    }

    public void setBtnListener(ComponentEventListener<ClickEvent<Button>> clickListener) {
        queryBtn.addClickListener(clickListener);
    }
}
