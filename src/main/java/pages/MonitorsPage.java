package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MonitorsPage {
    private static final SelenideElement filterBlockTitle = $x("//div[@class = 'filter-block__title']");
    private static final SelenideElement priceTitle = $x("//p[@class='title'] ");
    private static final SelenideElement availableProductsLabel = $x("//label[@for = 'fltr-1']");
    private static final SelenideElement availableProductsCheckbox = $x("//input[@id = 'fltr-1']");
    private static final SelenideElement manufacturerTitle = $(byText("Виробник"));
    private static final SelenideElement maxPriceInput = $x("//input[@class = 'form-control form-control-max']");
    private static final SelenideElement showButton = $(withText("Показати"));
    private static final SelenideElement priceTag = $x("//a[@class = 'tags__item']");
    private static final SelenideElement acerLabel = $x("//label[@for = 'fltr-proizvoditel-acer']");
    private static final SelenideElement acerCheckbox = $x("//input[@id = 'fltr-proizvoditel-acer']");
    private static final SelenideElement acerTag = $x("//a[@class = 'tags__item'][2]");
    private static final SelenideElement resetFilterButton = $x("//a[@class = 'button-reset btn-reset-filter ']");
    private static final SelenideElement pageTitleCategory = $x("//div[@class = 'page-title page-title-category']");
    private static final ElementsCollection filteredMonitorsList = $$x("//div[@class = 'prod-cart__descr']");

    public SelenideElement getFilterBlockTitle() { return filterBlockTitle;}

    public SelenideElement getPriceTitle() { return priceTitle;}

    public SelenideElement getAvailableProductsLabel() { return availableProductsLabel;}

    public SelenideElement getAvailableProductsCheckbox() { return availableProductsCheckbox;}

    public SelenideElement getManufacturerTitle() { return manufacturerTitle;}

    public SelenideElement getMaxPriceInput() { return  maxPriceInput;}

    public SelenideElement getShowButton() { return showButton;}

    public SelenideElement getPriceTag() { return priceTag;}

    public SelenideElement getAcerLabel() { return acerLabel;}

    public SelenideElement getAcerCheckbox() { return acerCheckbox;}

    public SelenideElement getAcerTag() { return acerTag;}

    public SelenideElement getResetFilterButton() { return resetFilterButton;}

    public SelenideElement getPageTitleCategory() {return pageTitleCategory;}

    public ElementsCollection getFilteredMonitorsList() { return filteredMonitorsList;}
}
