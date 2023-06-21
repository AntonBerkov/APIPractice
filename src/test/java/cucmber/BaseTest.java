package cucmber;

import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.*;

import static model.Driver.getDriver;

public class BaseTest {

    static WebDriver driver = getDriver();

    @AfterAll
    public static void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.quit();
        driver.close();
    }

}
