package services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

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
}
