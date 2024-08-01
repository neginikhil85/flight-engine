package com.learning.ui.component.card;

import com.learning.ui.component.text.LabeledValue;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.util.StringUtils;

import java.awt.Color;
import java.util.Collection;

public class CustomCard extends VerticalLayout {

    private final Div cardContent;
    private boolean isClickable;
    private final int lightenPercent;

    public CustomCard(String title, boolean isClickable) {
        this(title);
        setClickable(isClickable);
    }

    public CustomCard(String title) {
        this.lightenPercent = 20;
        // Initialize the card content container
        cardContent = new Div();
        cardContent.addClassName("custom-card");

        // Create the title element
        if (StringUtils.hasText(title)) {
            H1 cardTitle = new H1(title);
            this.addContent(cardTitle, Alignment.CENTER);
        }

        // Add the card content to the layout
        add(cardContent);
    }

    public void addContent(Component component, Alignment alignment) {
        cardContent.add(component);
        setHorizontalComponentAlignment(alignment, component);
    }

    public void addLabeledValue(Collection<LabeledValue> components) {
        components.forEach(this::addContent);
    }


    public void addContent(Component component) {
        addContent(component, Alignment.AUTO);
    }

    public void setClickable(boolean clickable) {
        isClickable = clickable;
        if (isClickable) {
            cardContent.addClassNames("custom-card-clickable");
        } else {
            cardContent.removeClassName("custom-card-clickable");
        }
    }

    public void setGradientBackground(String color) {
        String gradient = "linear-gradient(45deg, " + color + ", " + lightenColor(color, lightenPercent) + ")";
        cardContent.getStyle().set("background", gradient);

        if (isDarkColor(color)) {
            cardContent.addClassName("custom-card-light-text");
        } else {
            cardContent.removeClassName("custom-card-light-text");
        }
    }

    private boolean isDarkColor(String color) {
        Color awtColor = parseColor(color);
        double brightness = (double) (awtColor.getRed() * 299 + awtColor.getGreen() * 587 + awtColor.getBlue() * 114) / 1000;
        return brightness < 128;
    }

    private String lightenColor(String color, int percent) {
        Color awtColor = parseColor(color);

        int r = awtColor.getRed();
        int g = awtColor.getGreen();
        int b = awtColor.getBlue();

        r = (int) (r + (255 - r) * (percent / 100.0));
        g = (int) (g + (255 - g) * (percent / 100.0));
        b = (int) (b + (255 - b) * (percent / 100.0));

        return String.format("#%02x%02x%02x", r, g, b);
    }

    private Color parseColor(String color) {
        try {
            // Handle named colors
            return (Color) Color.class.getField(color.toUpperCase()).get(null);
        } catch (Exception e) {
            // Not a named color, continue to check for hex code
        }

        // Handle hex colors
        try {
            if (color.startsWith("#")) {
                return Color.decode(color);
            } else if (color.matches("[0-9A-Fa-f]{6}")) {
                return Color.decode("#" + color);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid color code: " + color, e);
        }

        throw new IllegalArgumentException("Invalid color code: " + color);
    }

    public boolean isClickable() {
        return isClickable;
    }

    public void addListenerOnClick(ComponentEventListener<ClickEvent<Div>> listener) {
        if (isClickable) {
            cardContent.addClickListener(listener);
        }
    }

}
