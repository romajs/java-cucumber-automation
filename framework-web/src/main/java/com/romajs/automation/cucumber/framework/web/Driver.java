package com.romajs.automation.cucumber.framework.web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    private static Dimension dimension;
    private static WebDriverWait wait;

    public static void open(final DriverType setting, final Class<?>... args) throws RuntimeException {
        DriverSystemPropertiesLoader.load("driver.properties");
        driver = setting.getDriver(args);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static void close() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }

    public static void setUrl(final String url) {
        driver.get(url);
    }

    public static void setWindowDimension(int x, int y) {
        dimension = new Dimension(x, y);
        driver.manage().window().setSize(dimension);
    }

    public static WebElement waitVisibleElement(final By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitInvisibilityElement(final By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static Alert waitIsPresentAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public static WebElement waitIsClickable(final By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}