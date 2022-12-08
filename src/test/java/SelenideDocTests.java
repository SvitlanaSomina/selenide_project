import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideDocTests {
    private static final String THE_INTERNET_HEROKUAPP_URL = "https://the-internet.herokuapp.com";
    private static final String PUREEXAMPLE_URL = "https://www.pureexample.com/jquery-ui/basic-droppable.html";
    private static final String SWISNL_GITHUB_URL = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
    private static final String GOOGLE_URL = "https://www.google.com/";
    private static final String AMAZON_URL = "https://www.amazon.com/";
    private static final String USERNAME_INPUT = "#username";
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD_INPUT = "#password";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String LOGIN_BUTTON = "button.radius";
    private static final String SUCCESSFUL_LOGIN_MESSAGE = "#flash.success";
    private static final String DROPDOWN_LIST = "#dropdown";
    private static final String DROPDOWN_OPTION = "Option 1";
    private static final String EXPECTED_VALUE_OF_DROPDOWN_OPTION = "1";
    private static final String CHOOSE_FILE_BUTTON = "file-upload";
    private static final String UPLOAD_BUTTON = "#file-submit";
    private static final String UPLOADED_FILES_MESSAGE = "#uploaded-files";
    private static final String CHECKBOX = "#checkbox";
    private static final String BUTTON = "button";
    private static final String EXACTLY_GIVEN_TEXT = "Remove";
    private static final String LOADING_BAR = "#loading";
    private static final String TABLE = "#table1";
    private static final String HEADERS = "tr>th";
    private static final int HEADERS_AMOUNT = 6;
    private static final String COLUMN_TEXT = "Email";
    private static final String TABLE_ROWS = "tbody tr";
    private static final int ROWS_AMOUNT = 3;
    private static final String FRAME = "iframe[id^='ExampleFrame-']";
    private static final String SOURCE_ELEMENT = ".square.ui-draggable";
    private static final String TARGET_ELEMENT = ".squaredotted.ui-droppable";
    private static final String INFO_MESSAGE = "#info";
    private static final String INFO_MESSAGE_TEXT = "dropped!";
    private static final String RIGHT_CLICK_ELEMENT = "//span[@class = 'context-menu-one btn btn-neutral']";
    private static final String CONTEXT_MENU = "//ul[@class = 'context-menu-list context-menu-root']";
    private static final String SEARCH_INPUT = "twotabsearchtextbox";
    private static final String SEARCH_QUERY = "apple";
    private static final String SEARCH_RESULTS = "//h2";
    private static final String EXPECTED_TEXT = "apple";
    private static final int SEARCH_RESULTS_AMOUNT = 16;
    private static final String BASIC_AUTH_MESSAGE = "//p";
    private static final String EXPECTED_BASIC_AUTH_MESSAGE_TEXT = "Congratulations";
    private static final String LOGIN_PASSWORD_BASIC_AUTH = "admin";
    private static final String BUTTONS = ".//a[contains(@class, 'button')]";
    private static final String CHALLENGING_DOM_HEADER = "//h3";
    String TEXT_FILE = "E:Users/home/OneDrive/Desktop/textFileForSelenide.txt";
    File textFile = new File(TEXT_FILE);

    /**
     * 1. Open Login page.
     * 2. Enter the username.
     * 3. Enter the password.
     * 4. Click on the Login button.
     * 5. Check if the message about successful logging is visible.
     */
    @Test
    public void inputElementTest(){
        open(THE_INTERNET_HEROKUAPP_URL + "/login");
        $(USERNAME_INPUT).setValue(USERNAME);
        $(PASSWORD_INPUT).setValue(PASSWORD);
        $(LOGIN_BUTTON).click();
        $(SUCCESSFUL_LOGIN_MESSAGE).shouldBe(Condition.visible);
    }

    /**
     * 1. Open Dropdown page.
     * 2. Find Dropdown List on the page.
     * 3. Select option from dropdown list.
     * 4. Check the expected value of "value" attribute.
     */
    @Test
    public void dropDownTest(){
        open(THE_INTERNET_HEROKUAPP_URL + "/dropdown");
        SelenideElement dropdown = $(DROPDOWN_LIST);
        dropdown.selectOption(DROPDOWN_OPTION);
        dropdown.getSelectedOption().shouldHave(Condition.value(EXPECTED_VALUE_OF_DROPDOWN_OPTION));
    }

    /**
     * 1. Open Upload page.
     * 2. Choose file for uploading.
     * 3. Click on the Upload button.
     * 4. Check that Uploaded files message contains the name of the uploaded file.
     */
    @Test
    public void uploadTest() throws IOException {
        open(THE_INTERNET_HEROKUAPP_URL + "/upload");
        $(byId(CHOOSE_FILE_BUTTON)).uploadFile(textFile);
        $(UPLOAD_BUTTON).click();
        $(UPLOADED_FILES_MESSAGE).shouldHave(Condition.text(textFile.getName()));
    }

    /**
     * 1. Open Download page.
     * 2. Download file by clicking this element.
     * 3. Check whether the contents of two files are equal.
     */
    @Test
    public void downloadTest() throws IOException {
        open(THE_INTERNET_HEROKUAPP_URL + "/upload");
        $(byId(CHOOSE_FILE_BUTTON)).uploadFile(textFile);
        $(UPLOAD_BUTTON).click();
        open(THE_INTERNET_HEROKUAPP_URL + "/download");
        File download = $(By.linkText(textFile.getName())).download();
        Assert.assertTrue(FileUtils.contentEquals(download, textFile));
    }

    /**
     * 1. Open Dynamic controls page.
     * 2. Check that Checkbox is visible and unchecked.
     * 3. Click on the Remove button.
     * 4. Check whether Loading bar is visible.
     * 5. Check whether Loading bar is not visible.
     * 6. Check whether Checkbox is not visible.
     */
    @Test
    public void waitersTest(){
        open("https://the-internet.herokuapp.com/dynamic_controls");
        $(CHECKBOX).shouldBe(Condition.visible, Condition.not(Condition.checked));
        $$(BUTTON).find(Condition.exactText(EXACTLY_GIVEN_TEXT)).click();
        $(LOADING_BAR).shouldBe(Condition.visible);
        $(LOADING_BAR).shouldBe(Condition.hidden);
        $(CHECKBOX).shouldNotBe(Condition.visible);
    }

    /**
     * 1. Open Tables page.
     * 2. Find Table on the page.
     * 3. Find Headers of the table.
     * 4. Check whether amount of the headers equals 6.
     * 5. Check whether one of the columns has text "Email".
     * 6. Gets all the texts in elements collection.
     * 7. Find rows of the table.
     * 8. Check whether the amount of the rows greater than 3.
     */
    @Test
    public void tableTest() {
        open(THE_INTERNET_HEROKUAPP_URL + "/tables");
        SelenideElement table = $(TABLE);
        List<String> headers = table.$$(HEADERS)
                .shouldBe(CollectionCondition.size(HEADERS_AMOUNT))
                .shouldHave(CollectionCondition.itemWithText(COLUMN_TEXT))
                .texts();
        ElementsCollection trs = table.$$(TABLE_ROWS).shouldHave(CollectionCondition.sizeGreaterThan(ROWS_AMOUNT));
    }

    /**
     * 1. Open Basic Droppable page.
     * 2. Switch to frame.
     * 3. Click and hold source element.
     * 4. Move source element to target element.
     * 5. Release mouse button.
     * 6. Build the chain of actions.
     * 7. Perform the chain of actions.
     * 8. Check whether info message contains text "dropped!".
     */
    @Test
    public void dragAndDropTest(){
        open(PUREEXAMPLE_URL);
        switchTo().frame($(FRAME));
        actions()
                .clickAndHold($(SOURCE_ELEMENT))
                .moveToElement($(TARGET_ELEMENT))
                .release()
                .build().perform();
        $(INFO_MESSAGE).shouldHave(Condition.text(INFO_MESSAGE_TEXT));
    }

    /**
     * 1. Open Basic Droppable page.
     * 2. Switch to frame.
     * 3. Find source element.
     * 4. Find target element.
     * 5. Click-and-hold at the location of the source element,moves to the location of the target element,
     then releases the mouse.
     * 6. Build the chain of actions.
     * 7. Perform the chain of actions.
     * 8. Check whether info message contains text "dropped!".
     */
    @Test
    public void dragAndDropTestSecondVersion(){
        open(PUREEXAMPLE_URL);
        switchTo().frame($(FRAME));
        SelenideElement source = $(SOURCE_ELEMENT);
        SelenideElement target = $(TARGET_ELEMENT);
        actions()
                .dragAndDrop(source, target)
                .build().perform();
        $(INFO_MESSAGE).shouldHave(Condition.text(INFO_MESSAGE_TEXT));
    }

    /**
     * 1. Open Demo page.
     * 2. Context-click on the right click element.
     * 3. Build the chain of actions.
     * 4. Perform the chain of actions.
     * 5. Check whether context menu is visible.
     */
    @Test
    public void rightClickTest(){
        open(SWISNL_GITHUB_URL);
        actions()
                .contextClick($x(RIGHT_CLICK_ELEMENT))
                .build().perform();
        $x(CONTEXT_MENU).shouldBe(Condition.visible);
    }

    /**
     * 1. Open Amazon main page.
     * 2. Enter search query into the search field.
     * 3. Click on the Search Submit button.
     * 4. Find elements of search results.
     * 5. Check whether every element of the search results contains expected text "xiaomi".
     * 6. Check whether the amount of search results equals 16.
     */
    @Test
    public void isSearchResultsContainsSearchWord(){
        open(AMAZON_URL);
        $(byId(SEARCH_INPUT)).setValue(SEARCH_QUERY).pressEnter();
        ElementsCollection elements = $$x(SEARCH_RESULTS);
        for(SelenideElement element : elements){
            element.shouldHave(Condition.text(EXPECTED_TEXT));
        }
        elements.shouldHave(CollectionCondition.size(SEARCH_RESULTS_AMOUNT));
    }

    /**
     * 1. Open Google main page.
     * 2. Open Amazon main page.
     * 3. Navigate browser back to previous page.
     * 4. Check whether Google main page is opened.
     * 5. Navigate browser forward to next page.
     * 6. Check whether Amazon main page is opened.
     */
    @Test
    public void navigateTest(){
        open(GOOGLE_URL);
        open(AMAZON_URL);
        back();
        webdriver().shouldHave(url(GOOGLE_URL));
        forward();
        webdriver().shouldHave(url(AMAZON_URL));
    }

    /**
     * 1. Open Basic auth page.
     * 2. Get text of basic auth message.
     * 3. Check whether text of basic auth message contains expected text.
     */
    @Test
    public void basicAuthPopUpTest(){
        open(THE_INTERNET_HEROKUAPP_URL + "/basic_auth", "", LOGIN_PASSWORD_BASIC_AUTH, LOGIN_PASSWORD_BASIC_AUTH);
        String basicAuthText = $x(BASIC_AUTH_MESSAGE).getText();
        Assert.assertTrue(basicAuthText.contains(EXPECTED_BASIC_AUTH_MESSAGE_TEXT));
    }

    /**
     * 1. Open Challenging DOM page.
     * 2. Check whether Challenging DOM header is visible.
     * 3. Find collection of buttons.
     * 4. Get the n-th element of buttons' collection and click on it.
     */
    @Test
    public void staleElementReferenceExceptionHandlingTest(){
        open(THE_INTERNET_HEROKUAPP_URL + "/challenging_dom");
        $x(CHALLENGING_DOM_HEADER).shouldBe(Condition.visible);
        ElementsCollection buttons = $$x(BUTTONS);
        for(int i = 0; i < buttons.size(); i++){
            buttons.get(i).click();
        }
    }
}
