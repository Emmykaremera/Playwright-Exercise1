package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Inventory;
import pages.LoginPage;
import utils.TestData;

public class ProductTest extends BaseTest {

    @Test
    public void productBrowsingTest(){

        LoginPage loginPage = new LoginPage(page);

        loginPage.login(
                TestData.USERNAME,
                TestData.PASSWORD
        );

        Inventory inventoryPage =
                new Inventory(page);

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products"
        );

        Assert.assertTrue(
                inventoryPage.getProductsCount() > 0
        );

        inventoryPage.openFirstProduct();

        Assert.assertFalse(inventoryPage.getOpenedProductName().isEmpty());
    }
}