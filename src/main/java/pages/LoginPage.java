package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page){
        this.page = page;
    }

    public void login(String username, String password){

        page.navigate("https://www.saucedemo.com");

        page.locator("#user-name").fill(username);
        page.locator("#password").fill(password);
        page.locator("#login-button").click();
    }

    public String getErrorMessage() {

        return page.locator("[data-test='error']")
                .innerText();
    }
}