package com.patterns.abstractFactory.application;

import com.patterns.abstractFactory.factory.DarkThemeFactory;
import com.patterns.abstractFactory.factory.LightThemeFactory;
import com.patterns.abstractFactory.factory.UIFactory;
import com.patterns.abstractFactory.product.Button;
import com.patterns.abstractFactory.product.Checkbox;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class AbstractFactoryApplicationTest {

    @Test
    void testLightThemeFactoryShouldCreateLightComponents() {
        UIFactory factory = new LightThemeFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        assertEquals("Light Button", button.render());
        assertEquals("Light Checkbox", checkbox.render());
    }

    @Test
    void testDarkThemeFactoryShouldCreateDarkComponents() {
        UIFactory factory = new DarkThemeFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        assertEquals("Dark Button", button.render());
        assertEquals("Dark Checkbox", checkbox.render());
    }

    @Test
    void testApplicationShouldUseFactoryToRenderComponents() {
        UIFactory factory = new LightThemeFactory();
        AbstractFactoryApplication app = new AbstractFactoryApplication(factory);

        String ui = app.renderUI();

        assertEquals("Light Button Light Checkbox", ui);
    }

}