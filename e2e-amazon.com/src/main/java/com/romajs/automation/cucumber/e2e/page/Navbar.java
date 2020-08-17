package com.romajs.automation.cucumber.e2e.page;

import com.romajs.automation.cucumber.e2e.mappers.Mappers;
import com.romajs.automation.cucumber.framework.web.ByValue;
import com.romajs.automation.cucumber.framework.web.Element;

public class Navbar {
    public Element amazonLogo = new Element(ByValue.ID, Mappers.AMAZON_LOGO);
    public Element searchBox = new Element(ByValue.ID, Mappers.SEARCH_BOX);
}
