package services;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static model.Driver.getDriver;

public class Services {
    public static String getProperty(String propertyName) {

        try (InputStream inputStream = Files.newInputStream(Paths.get("src/test/resources/test-data.properties"))) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForAllElements(List<WebElement> elements){
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
