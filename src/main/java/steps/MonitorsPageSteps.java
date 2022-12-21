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

    public MonitorsPageSteps clickAvailableProductsLabel() {
        monitorsPage.getAvailableProductsLabel().click();
        return this;
    }

    public MonitorsPageSteps checkWhetherAvailableProductsCheckboxIsChecked() {
        monitorsPage.getAvailableProductsCheckbox().shouldBe(Condition.checked);
        return this;
    }

    public MonitorsPageSteps checkWhetherManufacturerTitleIsVisible() {
        monitorsPage.getManufacturerTitle().shouldBe(Condition.visible);
        return this;
    }

    public MonitorsPageSteps enterMaxPriceValue(String price) {
        monitorsPage.getMaxPriceInput().setValue(price).pressEnter();
        return this;
    }

    public MonitorsPageSteps clickShowButton() {
        executeJavaScript(
                "arguments[0].click()", monitorsPage.getShowButton());
        return this;
    }

    public MonitorsPageSteps checkWhetherPriceTagIsVisible() {
        monitorsPage.getPriceTag().shouldBe(Condition.visible);
        return this;
    }

    public MonitorsPageSteps checkPriceTagText(String expectedText) {
        monitorsPage.getPriceTag().shouldHave(Condition.text(expectedText));
        return this;
    }

    public MonitorsPageSteps clickAcerLabel() {
        monitorsPage.getAcerLabel().click();
        return this;
    }

    public MonitorsPageSteps checkWhetherAcerCheckboxIsChecked() {
        monitorsPage.getAcerCheckbox().shouldBe(Condition.checked);
        return this;
    }

    public MonitorsPageSteps checkWhetherAcerTagIsVisible() {
        monitorsPage.getAcerTag().shouldBe(Condition.visible);
        return this;
    }

    public MonitorsPageSteps checkAcerTagText(String expectedText) {
        monitorsPage.getAcerTag().shouldHave(Condition.text(expectedText));
        return this;
    }

    public MonitorsPageSteps checkWhetherResetFilterButtonIsVisible() {
        monitorsPage.getResetFilterButton().shouldBe(Condition.visible);
        return this;
    }

    public MonitorsPageSteps checkResetFilterButtonText(String expectedText) {
        monitorsPage.getResetFilterButton().shouldHave(Condition.text(expectedText));
        return this;
    }

    public MonitorsPageSteps checkPageTitleCategoryText(String expectedText) {
        monitorsPage.getPageTitleCategory().shouldHave(Condition.text(expectedText));
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
