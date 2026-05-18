package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Inventory {

        private final Page page;

        public Inventory (Page page){
            this.page = page;
        }

        private final String productTitle = ".title";
        private final String inventoryItems = ".inventory_item";
        private final String firstProduct = ".inventory_item_name";
        private final String sortDropdown =
                "[data-test='product-sort-container']";

        public String getPageTitle(){

            return page.locator(productTitle)
                    .innerText();
        }

        public int getProductsCount(){

            return page.locator(inventoryItems)
                    .count();
        }

        public void openFirstProduct(){

            page.locator(firstProduct)
                    .first()
                    .click();
        }

        public String getOpenedProductName(){

            return page.locator(".inventory_details_name")
                    .innerText();
        }

        public void sortProducts(String option){

            page.locator(sortDropdown)
                    .selectOption(option);
        }





    public void addFirstProductToCart() {
        page.locator("button[data-test^='add-to-cart']")
                .first()
                .click();
    }

    public String getCartBadgeCount() {
        return page.locator(".shopping_cart_badge")
                .innerText();
    }
    }

