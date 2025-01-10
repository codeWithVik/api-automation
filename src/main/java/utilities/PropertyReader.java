package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private final String PROPERTIES_PATH = "src/main/resources/application.properties";

    private static final Properties properties = new Properties();

    public PropertyReader() {
        loadProperties();
    }

    private void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream(PROPERTIES_PATH);
            properties.load(fis);
        } catch (IOException ex) {
            throw new IllegalArgumentException(".properties file could not be loaded.");
        }
    }

    public static String getProperty(String field) {
        return properties.getProperty(field);
    }

}
