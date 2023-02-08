package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import pages.TradeInPage;

public class TradeInPageSteps {
    TradeInPage tradeInPage = new TradeInPage();

    public TradeInPageSteps checkDeviceTypeFormElements(String expectedText) {
        tradeInPage.getPageTitle().shouldBe(Condition.visible);
        tradeInPage.getDeviceTypeLabel().shouldBe(Condition.visible);
        tradeInPage.getCategoryContainer().shouldHave(Condition.text(expectedText));
        clickNextButton();
        return this;
    }

    public TradeInPageSteps clickNextButton() {
        tradeInPage.getNextButton().click();
        return this;
    }

    public TradeInPageSteps fillInSmartphoneInfo(String model, String product) {;
        tradeInPage.getSelectModelDropdown().selectOption(model);
        tradeInPage.getProductsSelectList().selectOptionContainingText(product);
        tradeInPage.getSelectProductDropdown().click();
        tradeInPage.getNextButton().shouldBe(Condition.visible);
        tradeInPage.getPreviousButton().shouldBe(Condition.visible);
        clickNextButton();
        return this;
    }

    public TradeInPageSteps fillInDeviceTurnOnInfo() {
        tradeInPage.getDeviceTurnOnLabel().shouldBe(Condition.visible);
        clickYesButton();
        clickNextButton();
        return this;
    }

    public TradeInPageSteps clickYesButton() {
        tradeInPage.getYesButton().click();
        return this;
    }

    public TradeInPageSteps fillInDeviceFunctionsInfo() {
        tradeInPage.getDeviceFunctionsLabel().shouldBe(Condition.visible);
        clickNoButton();
        clickNextButton();
        return this;
    }

    public TradeInPageSteps clickNoButton() {
        tradeInPage.getNoButton().click();
        return this;
    }

    public TradeInPageSteps fillInDeviceStateInfo() {
        tradeInPage.getDeviceStateLabel().shouldBe(Condition.visible);
        tradeInPage.getDisplayHasNoScratchesButton().click();
        clickNextButton();
        return this;
    }

    public TradeInPageSteps fillInDeviceConfigurationInfo() {
        tradeInPage.getDeviceConfigurationLabel().shouldBe(Condition.visible);
        tradeInPage.getPartialConfigurationButton().click();
        clickNextButton();
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
