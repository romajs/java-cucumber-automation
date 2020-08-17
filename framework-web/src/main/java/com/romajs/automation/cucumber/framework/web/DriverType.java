package com.romajs.automation.cucumber.framework.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum DriverType {
    CHROME(ChromeDriver.class);

    private Class clazz;

    <T extends WebDriver> DriverType(Class<T> clazz) {
        this.clazz = clazz;
    }

    public <T extends WebDriver> Class<T> getClazz() {
        return clazz;
    }

    public WebDriver getDriver(Class<?>[] args) {
        try {
            return getClazz().getDeclaredConstructor(args).newInstance();
        } catch (ReflectiveOperationException exception) {
            throw new RuntimeException(exception);
        }
    }
}
