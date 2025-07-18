package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load config.properties");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
