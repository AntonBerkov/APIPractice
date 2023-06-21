package pages;

import model.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    private final WebDriver driver;

    public AbstractPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    protected WebDriver getDriver(){
        return this.driver;
    }
}
