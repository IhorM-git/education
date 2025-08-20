package com.patterns.abstractFactory.factory;

public class ThemeFactory {
    public UIFactory getTheme(String themeType) {
        return switch (themeType) {
            case "Dark" -> new DarkThemeFactory();
            case "Light" -> new LightThemeFactory();
            default -> throw new IllegalArgumentException("Unknown type: " + themeType);
        };
    }
}
