package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "https://github.com/AntonBerkov/GoogleTranslateAPIPractice/blob/6fe9d13a20b602c6a53d82846c6fac3133bd76a4/src/test/resources/drivers/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
