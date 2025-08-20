package com.patterns.abstractFactory.factory;

import com.patterns.abstractFactory.product.Button;
import com.patterns.abstractFactory.product.Checkbox;

public interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
