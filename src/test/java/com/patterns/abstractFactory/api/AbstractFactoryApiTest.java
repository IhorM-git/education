package com.patterns.abstractFactory.api;

import jakarta.enterprise.context.ApplicationScoped;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApplicationScoped
class AbstractFactoryApiTest {

    @Test
    void testApplicationShouldUseFactoryToRenderComponents() {
        AbstractFactoryApi api = new AbstractFactoryApi();
        String themeType = "Light";
        String ui = api.render(themeType);
        assertEquals("Light Button Light Checkbox", ui);
    }

}