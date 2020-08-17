package com.romajs.automation.cucumber.e2e.page;

import com.romajs.automation.cucumber.framework.web.Element;
import org.openqa.selenium.Keys;

import java.util.List;

public class HomePage implements Page {

    public static final String ALIAS = "home";

    final Navbar navbar = new Navbar();
    final ProductResultList productsResultList = new ProductResultList();

    public void searchProduct(final String value) {
        navbar.searchBox.sendKeys(value, Keys.ENTER);
        productsResultList.waitForLoad();
    }

    public List<Product> getProductsResultList() {
        return productsResultList.getProductsResultList();
    }

    @Override
    public String getUrl() {
        return "https://www.amazon.com/";
    }

    @Override
    public Element waitForLoad() {
        return navbar.amazonLogo.waitVisibleElement();
    }
}
