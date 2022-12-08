import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class GoogleTests {
    private static final String GOOGLE_URL = "https://www.google.com/";
    private static final String SEARCH_INPUT = "q";
    private static final String SEARCH_QUERY = "selenide";
    private static final String SEARCH_RESULTS = "//h3[@class = 'LC20lb MBeuO DKV0Md']";
    private static final String EXPECTED_TEXT = "Selenide";
    private static final int SEARCH_RESULTS_AMOUNT = 11;
    private static final String FILE_NAME = "screenshot";
    private static final String GOOGLE_LOGO = "//img[@alt = 'Google']";
    private static final String MAIL_BUTTON = "//a[@class = 'gb_j']";

    /**
     * 1. Open Google main page.
     * 2. Find Search input and enter the search query.
     * 3. Find search results and check whether search results amount equals 11.
     * 4. Check whether the first search result contains expected text "Selenide".
     * 5. Make a screenshot into the file screenshot.png
     */
    @Test
    public void searchSelenideTest(){
        open(GOOGLE_URL);
        $(By.name(SEARCH_INPUT)).setValue(SEARCH_QUERY).pressEnter();
        $$x(SEARCH_RESULTS).shouldHave(CollectionCondition.size(SEARCH_RESULTS_AMOUNT));
        $x(SEARCH_RESULTS).shouldHave(Condition.text(EXPECTED_TEXT));
        screenshot(FILE_NAME);
    }

    /**
     * 1. Open Google main page.
     * 2. Find Search input and enter the search query.
     * 3. Among results find element by text "Selenide: concise UI tests in Java" and check whether it is visible.
     */
    @Test
    public void searchElementByTextTest(){
        open(GOOGLE_URL);
        $(By.name(SEARCH_INPUT)).setValue(SEARCH_QUERY).pressEnter();
        $(byText("Selenide: concise UI tests in Java")).shouldBe(Condition.visible);
    }

    /**
     * 1. Open Google main page.
     * 2. Find Search input and enter the search query.
     * 3. Find element containing given text (as a substring). Check that this element contains
     * given text "Selenide: concise UI tests in Java".
     */
    @Test
    public void searchElementWithTextTest(){
        open(GOOGLE_URL);
        $(By.name(SEARCH_INPUT)).setValue(SEARCH_QUERY).pressEnter();
        $(withText("concise")).shouldHave(Condition.text("Selenide: concise UI tests in Java"));
    }

    /**
     * 1. Open Google main page.
     * 2. Find element Google logo and check that element has the given class "lnXdpd".
     */
    @Test
    public void givenClassOfElementTest(){
        open(GOOGLE_URL);
        $x(GOOGLE_LOGO).shouldHave(Condition.cssClass("lnXdpd"));
    }

    /**
     * 1. Open Google main page.
     * 2. Check whether Mail button is visible on the page.
     * 3. Find Search input and enter the search query.
     * 4. Check whether Mail button is not visible.
     */
    @Test
    public void mailButtonDisappearTest(){
        open(GOOGLE_URL);
        $x(MAIL_BUTTON).shouldBe(Condition.visible);
        $(By.name(SEARCH_INPUT)).setValue(SEARCH_QUERY).pressEnter();
        $x(MAIL_BUTTON).shouldNotBe(Condition.visible);
    }
}
