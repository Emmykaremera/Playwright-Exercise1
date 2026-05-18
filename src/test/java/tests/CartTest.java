package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.Inventory;
import pages.LoginPage;
import utils.TestData;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(page);
        loginPage.login(
                TestData.USERNAME,
                TestData.PASSWORD
        );

        Inventory inventoryPage = new Inventory(page);

        String expectedProductName = page.locator(".inventory_item_name")
                        .first()
                        .innerText();

        inventoryPage.addFirstProductToCart();

        Assert.assertEquals(inventoryPage.getCartBadgeCount(),
                "1"
        );

        CartPage cartPage = new CartPage(page);
        cartPage.openCart();

        Assert.assertEquals(cartPage.getCartItemsCount(),
                1
        );

        Assert.assertEquals(cartPage.getFirstCartItemName(),
                expectedProductName
        );
    }
}