package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton_Berkov\\APIPractice\\src\\test\\resources\\chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65535).build());
            driver.manage().window().maximize();
        }
        return driver;
    }
}
