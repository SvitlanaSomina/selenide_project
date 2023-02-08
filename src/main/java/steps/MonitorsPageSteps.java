package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.MonitorsPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MonitorsPageSteps {
    MonitorsPage monitorsPage = new MonitorsPage();

    public String getFilterBlockTitleText() {
        return monitorsPage.getFilterBlockTitle().getText();
    }

    public String getPriceTitleText() {
        return monitorsPage.getPriceTitle().getText();
    }

    public MonitorsPageSteps selectOnlyAvailableProducts() {
        monitorsPage.getAvailableProductsLabel().click();
        monitorsPage.getAvailableProductsCheckbox().shouldBe(Condition.checked);
        return this;
    }

    public MonitorsPageSteps selectManufacturer(String filterText, String pageTitleCategoryText) {
        monitorsPage.getManufacturerTitle().shouldBe(Condition.visible);
        monitorsPage.getAcerLabel().click();
        monitorsPage.getAcerCheckbox().shouldBe(Condition.checked);
        monitorsPage.getAcerTag().shouldBe(Condition.visible);
        monitorsPage.getAcerTag().shouldHave(Condition.text(filterText));
        monitorsPage.getPageTitleCategory().shouldHave(Condition.text(pageTitleCategoryText));
        return this;
    }

    public MonitorsPageSteps selectMaxPrice(String price, String expectedText) {
        monitorsPage.getMaxPriceInput().setValue(price).pressEnter();
        clickShowButton();
        monitorsPage.getPriceTag().shouldBe(Condition.visible);
        monitorsPage.getPriceTag().shouldHave(Condition.text(expectedText));
        return this;
    }

    public MonitorsPageSteps clickShowButton() {
        executeJavaScript(
                "arguments[0].click()", monitorsPage.getShowButton());
        return this;
    }

    public MonitorsPageSteps checkResetFilterButton(String expectedText) {
        monitorsPage.getResetFilterButton().shouldBe(Condition.visible);
        monitorsPage.getResetFilterButton().shouldHave(Condition.text(expectedText));
        return this;
    }

    public MonitorsPageSteps checkFilteredMonitorsList(int elementsAmount, String categoryWord) {
        checkElementsAmountInFilteredMonitorsList(elementsAmount);
        checkWhetherElementsOfFilteredMonitorsListContainCategoryWord(categoryWord);
        return this;
    }

    public MonitorsPageSteps checkElementsAmountInFilteredMonitorsList(int elementsAmount) {
        monitorsPage.getFilteredMonitorsList().shouldHave(CollectionCondition.size(elementsAmount));
        return this;
    }

    public MonitorsPageSteps checkWhetherElementsOfFilteredMonitorsListContainCategoryWord(String categoryWord) {
        ElementsCollection elements = monitorsPage.getFilteredMonitorsList();
        for (SelenideElement element : elements) {
            element.shouldHave(Condition.text(categoryWord));
        }
        return this;
    }
}
