package com.learning.ui.component.form;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

@Getter
public class FlightForm extends FormLayout {

    // Define the TextField components
    TextField flightNumber = new TextField("Flight Number");
    TextField startTerminal = new TextField("Start Terminal");
    TextField endTerminal = new TextField("End Terminal");
    TextField startDateTime = new TextField("Start Date Time");
    TextField endDateTime = new TextField("End Date Time");

    // Layouts for mandatory and optional fields
    VerticalLayout mandatoryLayout = new VerticalLayout();
    VerticalLayout optionalLayout = new VerticalLayout();

    public FlightForm() {
        addClassName("flight-form");

        // Add fields to their respective layouts
        mandatoryLayout.add(flightNumber, startTerminal, endTerminal, startDateTime);
        optionalLayout.add(endDateTime);

        // Create Accordion sections
        Accordion accordion = new Accordion();
        accordion.add("Mandatory Fields", mandatoryLayout);
        accordion.add("Optional Fields", optionalLayout);

        // Add Accordion to the form
        add(accordion);
    }
}
