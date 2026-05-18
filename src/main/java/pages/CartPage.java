package pages;

import com.microsoft.playwright.Page;

public class CartPage {

    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    private final String cartIcon = ".shopping_cart_link";
    private final String cartItems = ".cart_item";
    private final String cartItemName = ".inventory_item_name";

    public void openCart() {
        page.locator(cartIcon).click();
    }

    public int getCartItemsCount() {
        return page.locator(cartItems).count();
    }

    public String getFirstCartItemName() {
        return page.locator(cartItemName)
                .first()
                .innerText();
    }
}