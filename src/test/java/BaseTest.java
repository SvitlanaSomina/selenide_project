import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private static final String AVIC_URL = "https://avic.ua/ua";
    protected MainPageSteps mainPageSteps = new MainPageSteps();
    protected SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();
    protected CartPageSteps cartPageSteps = new CartPageSteps();
    protected TradeInPageSteps tradeInPageSteps = new TradeInPageSteps();
    protected ComputersPageSteps computersPageSteps = new ComputersPageSteps();
    protected MonitorsPageSteps monitorsPageSteps = new MonitorsPageSteps();

    @BeforeMethod
    public void testsSetup() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        open(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
