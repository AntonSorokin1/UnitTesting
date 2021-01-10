package example.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesService {
    private static final Logger LOGGER = Logger.getLogger(PropertiesService.class.getName());

    private static final String PROPERTIES_PATH = "properties/paths.properties";
    private static Properties properties = null;

    private PropertiesService() {}

    private static void getProperties() {
        properties = new Properties();
        try (InputStream inputStream = PropertiesService.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH)) {
            properties.load(inputStream);
        }
        catch (NullPointerException | IOException e) {
            LOGGER.warning("Can not read properties!");
        }
    }

    public static String getProperty(String key) {
        if (properties == null) getProperties();
        return properties.getProperty(key);
    }
}
