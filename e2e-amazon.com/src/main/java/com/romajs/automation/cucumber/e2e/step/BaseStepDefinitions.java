package com.romajs.automation.cucumber.e2e.step;

import com.romajs.automation.cucumber.e2e.page.HomePage;
import com.romajs.automation.cucumber.e2e.page.Page;
import com.romajs.automation.cucumber.framework.web.Driver;
import com.romajs.automation.cucumber.framework.web.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BaseStepDefinitions {
    static final Map<String, Page> pagesByAlias = new HashMap<>();

    {
        pagesByAlias.put(HomePage.ALIAS, new HomePage());
    }

    Page currentPage;

    @Before
    public void driverUp() {
        Driver.open(DriverType.CHROME);
    }

    @After
    public void driverDown() {
        Driver.close();
    }

    @Given("customer access {string} page")
    public void customerAccessPage(final String alias) {
        currentPage = pagesByAlias.get(alias);
        currentPage.open();
        assertEquals(currentPage.getUrl(), Driver.getUrl());
    }
}
