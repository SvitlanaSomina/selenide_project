package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TradeInPage {
    private static final SelenideElement pageTitle = $x("//h1[@class= 'page-title']");
    private static final SelenideElement deviceTypeLabel = $x("//label[@for = 'device_type']");
    private static final SelenideElement categoryContainer = $(byId("select2-category-container"));
    private static final SelenideElement nextButton = $(byId("nextBtn"));
    private static final SelenideElement selectModelDropdown = $(byId("model"));
    private static final SelenideElement productsSelectList = $(byId("product"));
    private static final SelenideElement selectProductDropdown = $(byId("select2-product-container"));
    private static final SelenideElement previousButton = $(byId("prevBtn"));
    private static final SelenideElement deviceTurnOnLabel = $(byText("Ваш пристрій вмикається?"));
    private static final SelenideElement yesButton = $(byText("Так"));
    private static final SelenideElement deviceFunctionsLabel = $(byText("Всі функції пристрою працюють?"));
    private static final SelenideElement noButton = $x("//button[@class = 'main-btn main-btn--tradein btn-tradein-fullwidth-small'][2]");
    private static final SelenideElement deviceStateLabel = $(byText("Виберіть стан пристрою."));
    private static final SelenideElement displayHasNoScratchesButton = $(byText("Дисплей та корпус не має подряпин і відколів"));
    private static final SelenideElement deviceConfigurationLabel = $(byText("Яка комплектація пристрою?"));
    private static final SelenideElement partialConfigurationButton = $(byText("Часткова комплектація"));
    private static final ElementsCollection finishSteps = $$(".step.finish");
    private static final SelenideElement tradeInLabel = $x("//div[@class = 'tradein-top']/p");
    private static final SelenideElement smartphonePrice = $x("//div[@class = 'tradein-top']/h2");

    public SelenideElement getPageTitle() { return pageTitle;}

    public SelenideElement getDeviceTypeLabel() { return deviceTypeLabel;}

    public SelenideElement getCategoryContainer() { return categoryContainer;}

    public SelenideElement getNextButton() { return nextButton;}

    public SelenideElement getSelectModelDropdown() { return selectModelDropdown;}

    public SelenideElement getProductsSelectList() { return productsSelectList;}

    public SelenideElement getSelectProductDropdown() { return selectProductDropdown;}

    public SelenideElement getPreviousButton() { return previousButton;}

    public SelenideElement getDeviceTurnOnLabel() { return deviceTurnOnLabel;}

    public SelenideElement getYesButton() { return yesButton;}

    public SelenideElement getDeviceFunctionsLabel() { return deviceFunctionsLabel;}

    public SelenideElement getNoButton() { return noButton;}

    public SelenideElement getDeviceStateLabel() { return deviceStateLabel;}

    public SelenideElement getDisplayHasNoScratchesButton() { return displayHasNoScratchesButton;}

    public SelenideElement getDeviceConfigurationLabel() { return deviceConfigurationLabel;}

    public SelenideElement getPartialConfigurationButton() { return partialConfigurationButton;}

    public ElementsCollection getFinishSteps() { return finishSteps;}

    public SelenideElement getTradeInLabel() { return tradeInLabel;}

    public SelenideElement getSmartphonePrice() { return smartphonePrice;}
}
