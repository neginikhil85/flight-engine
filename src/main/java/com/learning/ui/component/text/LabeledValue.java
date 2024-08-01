package com.learning.ui.component.text;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LabeledValue extends HorizontalLayout {

    private final Span label;
    private final Span value;

    public LabeledValue(String labelText) {
        this(labelText, "N/A");
    }

    public LabeledValue(String labelText, String initialValue) {
        this.label = new Span(labelText);
        this.label.addClassName("lv-label");

        this.value = new Span(initialValue);
        this.value.addClassName("lv-value");

        addClassName("labeled-value");

        add(value); // label
    }

    public void setValue(String newValue) {
        value.setText(newValue);
    }

    public String getValue() {
        return value.getText();
    }

    public void setLabel(String newLabel) {
        label.setText(newLabel);
    }

    public String getLabel() {
        return label.getText();
    }
}
