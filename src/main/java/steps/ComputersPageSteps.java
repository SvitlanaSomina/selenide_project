package steps;

import pages.ComputersPage;

public class ComputersPageSteps {
    ComputersPage computersPage = new ComputersPage();

    public void clickMonitorsButton() {
        computersPage.getMonitorsButton().click();
    }
}
