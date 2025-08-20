package com.patterns.abstractFactory.product;

public class DarkButton implements Button {
    @Override
    public String render() {
        return "Dark Button";
    }
}
