package com.romajs.automation.cucumber.framework.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Element {
    private static final HashMap<ByValue, Function<String, By>> byMap = new HashMap<>();

    static {
        byMap.put(ByValue.ID, (value) -> By.id(value));
        byMap.put(ByValue.CSS, (value) -> By.cssSelector(value));
        byMap.put(ByValue.LINKTEXT, (value) -> By.linkText(value));
        byMap.put(ByValue.NAME, (value) -> By.name(value));
        byMap.put(ByValue.XPATH, (value) -> By.xpath(value));
    }


    private ByValue byValue;
    private String value;
    private By by;
    private WebElement element;
    private Alert alert = null;

    public Element(ByValue byValue, String value) {
        this.byValue = byValue;
        this.value = value;
        this.by = byMap.get(byValue).apply(value);
    }

    public WebElement getElement() {
        return Driver.getDriver().findElement(by);
    }

    public List<WebElement> getElements() {
        return Driver.getDriver().findElements(by);
    }

    public void sendKeys(CharSequence... value) {
        getElement().sendKeys(value);
    }

    public String getText() {
        return getElement().getText();
    }

    public void click() {
        getElement().click();
    }

    public String getAttribute(String value) {
        return getElement().getAttribute(value);
    }

    public Element clear() {
        getElement().clear();
        return this;
    }

    public boolean isEnable() {
        return getElement().isEnabled();
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    public boolean isSelected() {
        return getElement().isSelected();
    }

    public void select(String value) {
        Select select = new Select(getElement());
        select.selectByVisibleText(value);
    }

    public Element waitVisibleElement() {
        this.element = Driver.waitVisibleElement(this.by);
        return this;
    }

    public void waitInvisibleElement() {
        Driver.waitInvisibilityElement(this.by);
    }

    public Element waitClickableElement() {
        this.element = Driver.waitIsClickable(this.by);
        return this;
    }

    public Element waitIsPresentAlert() {
        this.alert = Driver.waitIsPresentAlert();
        return this;
    }
}
