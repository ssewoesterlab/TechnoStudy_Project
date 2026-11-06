package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        FileInputStream fis = null;


        try {
            fis = new FileInputStream("src/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
public static String get(String key){
        return properties.getProperty(key);
}

}
