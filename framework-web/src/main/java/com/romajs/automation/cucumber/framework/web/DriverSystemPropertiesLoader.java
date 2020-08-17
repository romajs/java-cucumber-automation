package com.romajs.automation.cucumber.framework.web;

import java.util.Properties;

class DriverSystemPropertiesLoader {

    static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    static final Properties systemProperties = System.getProperties();

    static void load(final String resourceName) throws RuntimeException {
        try {
            systemProperties.load(classLoader.getResourceAsStream(resourceName));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
