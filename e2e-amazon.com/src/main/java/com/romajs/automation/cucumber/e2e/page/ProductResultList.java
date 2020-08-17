package com.romajs.automation.cucumber.e2e.page;

import com.romajs.automation.cucumber.e2e.mappers.Mappers;
import com.romajs.automation.cucumber.framework.web.ByValue;
import com.romajs.automation.cucumber.framework.web.Element;

import java.util.List;
import java.util.stream.Collectors;

public class ProductResultList {
    public Element productsResultList = new Element(ByValue.CSS, Mappers.PRODUCTS_RESULT_LIST);

    public List<Product> getProductsResultList() {
        return productsResultList.getElements().stream().map(Product::new).collect(Collectors.toList());
    }

    public Product getProduct(final int index) {
        return new Product(productsResultList.getElements().get(index));
    }

    public void waitForLoad() {
        productsResultList.waitVisibleElement();
    }

}
