package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static services.Services.waitForAllElements;

public class WowHeadHomePage extends AbstractPage {


    @FindBy(xpath = "//*[@class='header-search']//input")
    private WebElement textField;

    @FindBy(xpath = "//*[@class='live-search-results']/a")
    private List<WebElement> searchResultLinks;

    public void searchInBase(String text) {
        textField.sendKeys(text);
    }

    public String clickOnLinkAndGetText() {
        waitForAllElements(searchResultLinks);
        WebElement link = searchResultLinks.get(0);
        String linkText = link.getText();
        link.click();
        return linkText;
    }
}
