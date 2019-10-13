package test.automation.properties;

import java.io.*;
import java.util.Properties;

public final class PropertiesOperations {

    public Properties getProperties(String fileName) throws IOException {
        Properties properties;
        properties = new Properties();
        FileInputStream file = new FileInputStream("PropertiesFiles\\Data.properties");
        properties.load(file);
        file.close();
        return properties;
    }

    public Properties setProperties(Properties properties, String key, String value) throws IOException {
        properties.setProperty(key, value);
        return properties;

    }
}