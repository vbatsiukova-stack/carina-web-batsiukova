package com.zebrunner.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class,'b-main-navigation__link') and contains(., 'Каталог')]")
    private ExtendedWebElement catalogButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        open();
    }

    public CatalogPage openCatalogPage() {
        catalogButton.scrollTo();
        catalogButton.click();
        return new CatalogPage(driver);
    }
}