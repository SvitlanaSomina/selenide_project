package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {
    private static final ElementsCollection searchResults = $$x("//div[@class = 'prod-cart height']");
    private static final SelenideElement buyButton = $x("//a[@class = 'prod-cart__buy'][1]");
    private static final SelenideElement productDescriptionFromSearchResults = $x("//div[@class = 'prod-cart__descr']");
    private static final SelenideElement cartCount = $x("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]");
    private static final SelenideElement pageTitle = $x("//div[@class = 'category-top']/div[@class = 'page-title']");

    public ElementsCollection getSearchResults() {
        return searchResults;
    }

    public SelenideElement getBuyButton() { return buyButton;}

    public SelenideElement getProductDescription() {return productDescriptionFromSearchResults;}

    public SelenideElement getCartCount() {return cartCount;}

    public SelenideElement getPageTitle() {return pageTitle;}
}
