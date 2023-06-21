package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WowHeadItemPage extends AbstractPage{

    @FindBy(xpath = "//*[contains(@class, 'heading-size-1')]")
    private WebElement itemTitle;

    public String getItemTitle(){
        return itemTitle.getText();
    }
}
