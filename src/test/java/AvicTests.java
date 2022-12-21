import org.testng.Assert;
import org.testng.annotations.Test;

public class AvicTests extends BaseTest {
    private static final String SEARCH_QUERY = "xiaomi";
    private static final String EXPECTED_PAGE_TITLE = "Результати пошуку";
    private static final int ELEMENTS_AMOUNT_ON_SEARCH_RESULTS_PAGE = 12;
    private static final String CART_PAGE_URL = "https://avic.ua/ua/search-results?query=xiaomi";
    private static final String EXPECTED_COUNT_VALUE = "1";
    private static final String EXPECTED_CATEGORY_TEXT = "Смартфон";
    private static final String MODEL = "iPhone 13 Pro";
    private static final String PRODUCT = "Смартфон Apple iPhone 13 Pro 256GB Dual Sim Silver (MLTC3)";
    private static final int EXPECTED_FINISH_STEPS_AMOUNT = 6;
    private static final String EXPECTED_SMARTPHONE_PRICE = "22291 грн";
    private static final String EXPECTED_FILTER_BLOCK_TITLE_TEXT = "Підбір за параметрами";
    private static final String EXPECTED_PRICE_TITLE_TEXT = "Ціна до, грн";
    private static final String MAX_PRICE = "15000";
    private static final String EXPECTED_PRICE_TAG_TEXT = "0-15000 грн";
    private static final String EXPECTED_FILTER_TEXT = "Acer";
    private static final String EXPECTED_RESET_BUTTON_TEXT = "Скинути фільтри";
    private static final String EXPECTED_PAGE_TITLE_CATEGORY = "Монітори  Acer";
    private static final int EXPECTED_FILTERED_ELEMENTS_AMOUNT = 12;

    @Test
    public void addProductToCartTest() {
        mainPageSteps.enterSearchQuery(SEARCH_QUERY);
        searchResultsPageSteps.checkPageTitle(EXPECTED_PAGE_TITLE)
                .checkWhetherSearchResultsContainCategoryWord(SEARCH_QUERY)
                .checkElementsAmountOnSearchResultsPage(ELEMENTS_AMOUNT_ON_SEARCH_RESULTS_PAGE)
                .clickBuyButton();
        cartPageSteps.checkCartPageUrl(CART_PAGE_URL)
                .checkChangeAmountCount(EXPECTED_COUNT_VALUE);
        Assert.assertEquals(searchResultsPageSteps.getProductDescriptionTextFromSearchResults(), cartPageSteps.getProductDescriptionTextFromCart());
        Assert.assertEquals(cartPageSteps.getProductPrice(), cartPageSteps.getTotalPrice());
        cartPageSteps.checkWhetherCheckoutButtonIsVisible()
                .checkWhetherContinueShoppingButtonIsVisible()
                .clickContinueShoppingButton();
        searchResultsPageSteps.checkWhetherCartCountEqualsExpectedValue(EXPECTED_COUNT_VALUE);
    }
    @Test
    public void tradeInTest() {
        mainPageSteps.clickTradeInButton();
        tradeInPageSteps.checkWhetherPageTitleIsVisible()
                .checkWhetherDeviceTypeLabelIsVisible()
                .checkCategoryContainerText(EXPECTED_CATEGORY_TEXT)
                .clickNextButton()
                .selectModel(MODEL)
                .selectProduct(PRODUCT)
                .clickSelectProductDropdown()
                .checkWhetherPreviousButtonIsVisible()
                .checkWhetherNextButtonIsVisible()
                .clickNextButton()
                .checkWhetherDeviceTurnOnLabelIsVisible()
                .clickYesButton()
                .clickNextButton()
                .checkWhetherDeviceFunctionsLabelIsVisible()
                .clickNoButton()
                .clickNextButton()
                .checkWhetherDeviceStateLabelIsVisible()
                .clickDisplayHasNoScratchesButton()
                .clickNextButton()
                .checkWhetherDeviceConfigurationLabelIsVisible()
                .clickPartialConfigurationButton()
                .clickNextButton()
                .checkFinishStepsAmount(EXPECTED_FINISH_STEPS_AMOUNT);
        Assert.assertEquals(tradeInPageSteps.getSmartphoneName(), PRODUCT);
        Assert.assertEquals(tradeInPageSteps.getSmartphonePriceValue(), EXPECTED_SMARTPHONE_PRICE);
    }
    @Test
    public void selectProductsByParametersTest() {
        mainPageSteps.clickComputersButton();
        computersPageSteps.clickMonitorsButton();
        Assert.assertEquals(monitorsPageSteps.getFilterBlockTitleText(), EXPECTED_FILTER_BLOCK_TITLE_TEXT);
        Assert.assertEquals(monitorsPageSteps.getPriceTitleText(), EXPECTED_PRICE_TITLE_TEXT );
        monitorsPageSteps.clickAvailableProductsLabel()
                .checkWhetherAvailableProductsCheckboxIsChecked()
                .checkWhetherManufacturerTitleIsVisible()
                .enterMaxPriceValue(MAX_PRICE)
                .clickShowButton()
                .checkWhetherPriceTagIsVisible()
                .checkPriceTagText(EXPECTED_PRICE_TAG_TEXT)
                .clickAcerLabel()
                .checkWhetherAcerCheckboxIsChecked()
                .checkWhetherAcerTagIsVisible()
                .checkAcerTagText(EXPECTED_FILTER_TEXT)
                .checkWhetherResetFilterButtonIsVisible()
                .checkResetFilterButtonText(EXPECTED_RESET_BUTTON_TEXT)
                .checkPageTitleCategoryText(EXPECTED_PAGE_TITLE_CATEGORY)
                .checkElementsAmountInFilteredMonitorsList(EXPECTED_FILTERED_ELEMENTS_AMOUNT)
                .checkWhetherElementsOfFilteredMonitorsListContainCategoryWord(EXPECTED_FILTER_TEXT);
        }
}
