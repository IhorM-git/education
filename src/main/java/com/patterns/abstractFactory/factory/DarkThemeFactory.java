package com.patterns.abstractFactory.factory;

import com.patterns.abstractFactory.product.Button;
import com.patterns.abstractFactory.product.Checkbox;
import com.patterns.abstractFactory.product.DarkButton;
import com.patterns.abstractFactory.product.DarkCheckbox;

public class DarkThemeFactory implements UIFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}
