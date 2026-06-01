package com.zebrunner.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobilePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href, '/mobile/')]")
    private List<ExtendedWebElement> productTitles;

    public MobilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductTemplateValid() {
        pause(3);
        return !productTitles.isEmpty();
    }

    public MobilePage selectAppleBrand() {
        getDriver().get("https://catalog.onliner.by/mobile?mfr%5B0%5D=apple");
        pause(2);
        return this;
    }

    public boolean isAppleFilterApplied() {
        return getDriver().getCurrentUrl().contains("apple");
    }

    public MobilePage searchForIphone(String model) {
        getDriver().get(
                "https://catalog.onliner.by/mobile?mfr%5B0%5D=apple&mobile_model%5Bquery%5D="
                        + model.replace(" ", "+")
        );
        pause(2);
        return this;
    }

    public boolean isIphoneSearchApplied() {
        return getDriver().getCurrentUrl().contains("mobile_model");
    }

    public ProductPage openIPhone17() {
        getDriver().get("https://catalog.onliner.by/mobile/apple/iphone17256bk");
        pause(2);
        return new ProductPage(getDriver());
    }
}