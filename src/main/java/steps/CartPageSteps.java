package steps;

import com.codeborne.selenide.Condition;
import pages.CartPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class CartPageSteps {
    CartPage cartPage = new CartPage();

    public CartPageSteps checkCartPageUrl(String url) {
        webdriver().shouldHave(url(url));
        return this;
    }

    public CartPageSteps checkChangeAmountCount(String expectedCountValue) {
        cartPage.getChangeAmountCount().shouldHave(Condition.value(expectedCountValue));
        return this;
    }

    public String getProductDescriptionTextFromCart(){
        return cartPage.getProductDescriptionFromCart().getText();
    }

    public String getProductPrice() {
        return cartPage.getProductPrice().getText();
    }

    public String getTotalPrice() {
        return cartPage.getTotalPrice().getText();
    }

    public CartPageSteps checkWhetherContinueShoppingButtonIsVisible() {
        cartPage.getContinueShoppingButton().shouldBe(Condition.visible);
        return this;
    }

    public CartPageSteps checkWhetherCheckoutButtonIsVisible() {
        cartPage.getCheckoutButton().shouldBe(Condition.visible);
        return this;
    }

    public void clickContinueShoppingButton() {
        cartPage.getContinueShoppingButton().click();
    }
}
