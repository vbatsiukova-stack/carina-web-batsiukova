package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.CatalogPage;
import com.zebrunner.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.demo.gui.pages.ProductPage;
import com.zebrunner.carina.demo.gui.pages.MobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerTest implements IAbstractTest {

    @Test
    public void testOpenOnliner() {

        HomePage homePage = new HomePage(getDriver());
        homePage.openPage();
    }

    @Test
    public void testOpenMobilePhonesPage() {

        HomePage homePage = new HomePage(getDriver());
        homePage.openPage();

        CatalogPage catalogPage = homePage.openCatalogPage();

        MobilePage mobilePage = catalogPage.openMobilePhonesPage();

        Assert.assertTrue(
                mobilePage.isProductTemplateValid(),
                "Product template is invalid"
        );

        mobilePage.selectAppleBrand();

        Assert.assertTrue(
                mobilePage.isAppleFilterApplied(),
                "Apple filter is not applied"
        );

        mobilePage.searchForIphone("iPhone 17");

        Assert.assertTrue(
                mobilePage.isIphoneSearchApplied(),
                "iPhone 17 search is not applied"
        );

        ProductPage productPage =
                mobilePage.openIPhone17();
        Assert.assertTrue(
                productPage.isIPhone17PageOpened(),
                "iPhone 17 product page is not opened"
        );
        Assert.assertTrue(
                productPage.getProductTitle().contains("iPhone 17"),
                "Wrong product title"
        );
    }
}