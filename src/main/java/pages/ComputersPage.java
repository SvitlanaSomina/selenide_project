package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ComputersPage {
    private static final SelenideElement monitorsButton = $x("//div[@class = 'brand-box__title']/a[contains(text(),'Монітори')]");

    public SelenideElement getMonitorsButton() { return monitorsButton;}
}
