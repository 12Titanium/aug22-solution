package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //This is used to raed from properties files and returns properties object
    public Properties initProp() {
        final Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Unable to read Properties file.");
        }
        return properties;
    }
}