package com.patterns.abstractFactory.application;

import com.patterns.abstractFactory.factory.UIFactory;
import com.patterns.abstractFactory.product.Button;
import com.patterns.abstractFactory.product.Checkbox;

public class AbstractFactoryApplication {

    private final Button button;
    private final Checkbox checkbox;

    public AbstractFactoryApplication(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }


    public String renderUI() {
        return button.render() + " " + checkbox.render();
    }
}
