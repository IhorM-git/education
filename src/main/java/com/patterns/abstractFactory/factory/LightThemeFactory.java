package com.patterns.abstractFactory.factory;

import com.patterns.abstractFactory.product.Button;
import com.patterns.abstractFactory.product.Checkbox;
import com.patterns.abstractFactory.product.LightButton;
import com.patterns.abstractFactory.product.LightCheckbox;

public class LightThemeFactory implements UIFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}
