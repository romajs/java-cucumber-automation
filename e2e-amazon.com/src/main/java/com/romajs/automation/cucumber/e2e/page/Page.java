package com.romajs.automation.cucumber.e2e.page;

import com.romajs.automation.cucumber.framework.web.Driver;
import com.romajs.automation.cucumber.framework.web.Element;

public interface Page {

    String getUrl();

    default void open() {
        Driver.setUrl(this.getUrl());
        waitForLoad();
    }

    Element waitForLoad();

}
