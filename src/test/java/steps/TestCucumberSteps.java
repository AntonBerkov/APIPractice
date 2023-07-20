package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import pages.WowHeadHomePage;
import pages.WowHeadItemPage;
import utils.Services;

import static model.Driver.getDriver;

public class TestCucumberSteps {

    static WebDriver driver = getDriver();
    WowHeadHomePage wowHeadHomePage = new WowHeadHomePage();
    WowHeadItemPage wowHeadItemPage = new WowHeadItemPage();

    static SoftAssertions softAssertions = new SoftAssertions();


    @Given("user is on the website page")
    public void userIsOnTheWebsitePage() {
        driver.navigate().to("https://www.wowhead.com/ru");
        Services services = new Services();
        services.rejectCookies();
        services.declineDialog();
    }

    @When("user enters search {string} in the text field")
    public void userEntersSearchTextInTheTextField(String text) {
        wowHeadHomePage.searchInBase(text);
    }

    @And("clicks on the first link")
    public void clicksOnTheLink() {
        wowHeadHomePage.clickOnLinkAndGetText();
    }

    @Then("page's title matches expected {string}")
    public void pageSTitleMatchesExpectedTitle(String title) {
        softAssertions.assertThat(wowHeadItemPage.getItemTitle()).as("Item title").isEqualTo(title);
    }

    @AfterAll
    public static void assertAll(){
        softAssertions.assertAll();
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
