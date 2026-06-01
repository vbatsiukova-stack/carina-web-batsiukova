package com.zebrunner.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends AbstractPage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public MobilePage openMobilePhonesPage() {
        getDriver().get("https://catalog.onliner.by/mobile");
        return new MobilePage(getDriver());
    }
}