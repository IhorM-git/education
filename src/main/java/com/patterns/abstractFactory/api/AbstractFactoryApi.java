package com.patterns.abstractFactory.api;

import com.patterns.abstractFactory.application.AbstractFactoryApplication;
import com.patterns.abstractFactory.factory.ThemeFactory;
import com.patterns.abstractFactory.factory.UIFactory;

public class AbstractFactoryApi {
    public String render(String themeType) {
        ThemeFactory themeFactory = new ThemeFactory();
        UIFactory factory = themeFactory.getTheme(themeType);
        AbstractFactoryApplication app = new AbstractFactoryApplication(factory);

        return app.renderUI();
    }
}
