package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class Services extends AbstractPage {

    @FindBy(xpath = "//button[@id='onetrust-reject-all-handler']")
    private WebElement rejectCookiesButton;

    @FindBy(xpath = "//*[@class='notifications-dialog-buttons-decline btn']")
    private WebElement declineButton;

    public void rejectCookies() {

        if(!getDriver().findElements(By.xpath("//button[@id='onetrust-reject-all-handler']")).isEmpty()){
            if (rejectCookiesButton.isDisplayed()) {
                rejectCookiesButton.click();
            }
        }
    }

    public void declineDialog() {
        if(!getDriver().findElements(By.xpath("//*[@class='notifications-dialog-buttons-decline btn']")).isEmpty()){
            if (!(declineButton ==null) && declineButton.isDisplayed()) {
                declineButton.click();
            }
        }
    }
}
