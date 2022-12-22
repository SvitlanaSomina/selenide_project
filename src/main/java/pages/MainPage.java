package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private static final SelenideElement searchInput = $(By.id("input_search"));
    private static final SelenideElement tradeInButton = $x("//a[@class = 'header-top__item']");
    private static final SelenideElement computersButton = $(byText("Комп'ютери"));

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public SelenideElement getTradeInButton() { return tradeInButton; }

    public SelenideElement getComputersButton() { return  computersButton;}
}
