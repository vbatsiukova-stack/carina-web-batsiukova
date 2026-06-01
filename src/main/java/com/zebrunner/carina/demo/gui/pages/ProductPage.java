package com.zebrunner.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(., 'iPhone 17')]")
    private ExtendedWebElement productTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isIPhone17PageOpened() {
        pause(2);

        return productTitle.isElementPresent()
                && getDriver().getCurrentUrl().contains("iphone17256bk");
    }
    public String getProductTitle() {
        return productTitle.getText();
    }
}
