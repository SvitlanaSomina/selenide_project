package steps;

import pages.MainPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    public MainPageSteps enterSearchQuery(String searchQuery) {
        mainPage.getSearchInput().setValue(searchQuery).pressEnter();
        return this;
    }

    public void clickTradeInButton() {
        mainPage.getTradeInButton().click();
    }

    public void clickComputersButton() {
        executeJavaScript(
                "arguments[0].click()", mainPage.getComputersButton());}
}
