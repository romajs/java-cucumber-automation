package com.romajs.automation.cucumber.e2e.page;

import com.romajs.automation.cucumber.e2e.mappers.Mappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Product {

    private WebElement product;

    public Product(WebElement product) {
        this.product = product;
    }

    public String getTitle() {
        return product.findElement(By.tagName(Mappers.PRODUCT_TITLE)).getText();
    }

    public String getPrice() {
        return product.findElement(By.cssSelector(Mappers.PRODUCT_PRICE)).getText().replace("\n", ".");
    }
}
