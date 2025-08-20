package com.patterns.abstractFactory.product;

public class DarkCheckbox implements Checkbox {
    @Override
    public String render() {
        return "Dark Checkbox";
    }
}
