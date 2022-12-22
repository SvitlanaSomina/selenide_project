package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private static final SelenideElement changeAmountCount = $x("//input[@class = 'js-changeAmount count']");
    private static final SelenideElement productDescriptionFromCart = $x("//span[@class = 'name']");
    private static final SelenideElement productPrice = $x("//span[@class = 'prise'][1]");
    private static final SelenideElement totalPrice = $x("//div[@class = 'item-total']/span[@class = 'prise']");
    private static final SelenideElement continueShoppingButton = $x("//a[@class = 'main-btn main-btn--orange']");
    private static final SelenideElement checkoutButton = $x("//a[@class = 'main-btn  main-btn--green']");

    public SelenideElement getChangeAmountCount() { return changeAmountCount;}

    public SelenideElement getProductDescriptionFromCart() {return productDescriptionFromCart;}

    public SelenideElement getProductPrice() { return productPrice;}

    public SelenideElement getTotalPrice() { return totalPrice;}

    public SelenideElement getContinueShoppingButton() { return continueShoppingButton;}

    public SelenideElement getCheckoutButton() { return checkoutButton;}
}
