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
        searchResultsPageSteps.checkSearchResults(EXPECTED_PAGE_TITLE, SEARCH_QUERY, ELEMENTS_AMOUNT_ON_SEARCH_RESULTS_PAGE)
                .clickBuyButton();
        cartPageSteps.checkCartContents(CART_PAGE_URL, EXPECTED_COUNT_VALUE);
        Assert.assertEquals(searchResultsPageSteps.getProductDescriptionTextFromSearchResults(), cartPageSteps.getProductDescriptionTextFromCart());
        Assert.assertEquals(cartPageSteps.getProductPrice(), cartPageSteps.getTotalPrice());
        cartPageSteps.checkCartButtonsVisibility()
                .clickContinueShoppingButton();
        searchResultsPageSteps.checkWhetherCartCountEqualsExpectedValue(EXPECTED_COUNT_VALUE);
    }
    @Test
    public void tradeInTest() {
        mainPageSteps.clickTradeInButton();
        tradeInPageSteps.checkDeviceTypeFormElements(EXPECTED_CATEGORY_TEXT)
                .fillInSmartphoneInfo(MODEL, PRODUCT)
                .fillInDeviceTurnOnInfo()
                .fillInDeviceFunctionsInfo()
                .fillInDeviceStateInfo()
                .fillInDeviceConfigurationInfo()
                .checkFinishStepsAmount(EXPECTED_FINISH_STEPS_AMOUNT);
        Assert.assertEquals(tradeInPageSteps.getSmartphoneName(), PRODUCT);
        Assert.assertEquals(tradeInPageSteps.getSmartphonePriceValue(), EXPECTED_SMARTPHONE_PRICE);
    }
    @Test
    public void selectProductsByParametersTest() {
        mainPageSteps.clickComputersButton();
        computersPageSteps.clickMonitorsButton();
        Assert.assertEquals(monitorsPageSteps.getFilterBlockTitleText(), EXPECTED_FILTER_BLOCK_TITLE_TEXT);
        Assert.assertEquals(monitorsPageSteps.getPriceTitleText(), EXPECTED_PRICE_TITLE_TEXT);
        monitorsPageSteps.selectOnlyAvailableProducts()
                .selectMaxPrice(MAX_PRICE, EXPECTED_PRICE_TAG_TEXT)
                .selectManufacturer(EXPECTED_FILTER_TEXT, EXPECTED_PAGE_TITLE_CATEGORY)
                .checkResetFilterButton(EXPECTED_RESET_BUTTON_TEXT)
                .checkFilteredMonitorsList(EXPECTED_FILTERED_ELEMENTS_AMOUNT, EXPECTED_FILTER_TEXT);
        }
}
