package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.SearchResultsPage;

public class SearchResultsPageSteps {
    SearchResultsPage searchResultsPage = new SearchResultsPage();


    public SearchResultsPageSteps checkWhetherSearchResultsContainCategoryWord(String categoryWord) {
        ElementsCollection elements = searchResultsPage.getSearchResults();
        for (SelenideElement element : elements) {
            element.shouldHave(Condition.text(categoryWord));
        }
        return this;
    }

    public SearchResultsPageSteps checkElementsAmountOnSearchResultsPage(int elementsAmount) {
        searchResultsPage.getSearchResults().shouldHave(CollectionCondition.size(elementsAmount));
        return this;
    }

    public void clickBuyButton() {
        searchResultsPage.getBuyButton().click();
    }

    public String getProductDescriptionTextFromSearchResults() {
        return searchResultsPage.getProductDescription().getText();
    }

    public SearchResultsPageSteps checkWhetherCartCountEqualsExpectedValue(String expectedValue) {
        searchResultsPage.getCartCount().shouldHave(Condition.text(expectedValue));
        return this;
    }

    public SearchResultsPageSteps checkPageTitle(String expectedPageTitle) {
        searchResultsPage.getPageTitle().shouldHave(Condition.text(expectedPageTitle));
        return this;
    }
}
