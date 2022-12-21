import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

public class BaseTest {
    private static final String AVIC_URL = "https://avic.ua/ua";
    protected MainPageSteps mainPageSteps = new MainPageSteps();
    protected SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps();
    protected CartPageSteps cartPageSteps = new CartPageSteps();
    protected TradeInPageSteps tradeInPageSteps = new TradeInPageSteps();
    protected ComputersPageSteps computersPageSteps = new ComputersPageSteps();
    protected MonitorsPageSteps monitorsPageSteps = new MonitorsPageSteps();

    @BeforeMethod
    public void testsSetup(){
        Selenide.open(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
