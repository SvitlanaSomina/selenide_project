package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import pages.TradeInPage;

public class TradeInPageSteps {
    TradeInPage tradeInPage = new TradeInPage();

    public TradeInPageSteps checkWhetherPageTitleIsVisible() {
        tradeInPage.getPageTitle().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps checkWhetherDeviceTypeLabelIsVisible() {
        tradeInPage.getDeviceTypeLabel().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps checkCategoryContainerText(String expectedText) {
        tradeInPage.getCategoryContainer().shouldHave(Condition.text(expectedText));
        return this;
    }

    public TradeInPageSteps clickNextButton() {
        tradeInPage.getNextButton().click();
        return this;
    }

    public TradeInPageSteps selectModel(String model) {
        tradeInPage.getSelectModelDropdown().selectOption(model);
        return this;
    }

    public TradeInPageSteps selectProduct(String product) {
        tradeInPage.getProductsSelectList().selectOption(product);
        return this;
    }

    public TradeInPageSteps clickSelectProductDropdown() {
        tradeInPage.getSelectProductDropdown().click();
        return this;
    }

    public TradeInPageSteps checkWhetherPreviousButtonIsVisible() {
        tradeInPage.getPreviousButton().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps checkWhetherNextButtonIsVisible() {
        tradeInPage.getNextButton().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps checkWhetherDeviceTurnOnLabelIsVisible() {
        tradeInPage.getDeviceTurnOnLabel().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps clickYesButton() {
        tradeInPage.getYesButton().click();
        return this;
    }

    public TradeInPageSteps checkWhetherDeviceFunctionsLabelIsVisible() {
        tradeInPage.getDeviceFunctionsLabel().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps clickNoButton() {
        tradeInPage.getNoButton().click();
        return this;
    }

    public TradeInPageSteps checkWhetherDeviceStateLabelIsVisible() {
        tradeInPage.getDeviceStateLabel().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps clickDisplayHasNoScratchesButton() {
        tradeInPage.getDisplayHasNoScratchesButton().click();
        return this;
    }

    public TradeInPageSteps checkWhetherDeviceConfigurationLabelIsVisible() {
        tradeInPage.getDeviceConfigurationLabel().shouldBe(Condition.visible);
        return this;
    }

    public TradeInPageSteps clickPartialConfigurationButton() {
        tradeInPage.getPartialConfigurationButton().click();
        return this;
    }

    public TradeInPageSteps checkFinishStepsAmount(int amount) {
        tradeInPage.getFinishSteps().shouldHave(CollectionCondition.size(amount));
        return this;
    }

    public String getSmartphoneName() {
        return tradeInPage.getTradeInLabel().getText();
    }

    public String getSmartphonePriceValue() {
        return tradeInPage.getSmartphonePrice().getText();
    }
}
