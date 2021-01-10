package example.tasks;

import entity.Shop;
import example.services.PropertiesService;
import util.JSONConverter;
import util.XMLConverter;
import util.impl.JSONConverterImpl;
import util.impl.XMLConverterImpl;

import java.io.File;
import java.util.logging.Logger;

public class Task {
    private static final Logger LOGGER = Logger.getLogger(Task.class.getName());

    public void start() {
        // Read paths to files
        String pathToXML = PropertiesService.getProperty("pathToXML");
        String pathToJSON = PropertiesService.getProperty("pathToJSON");
        // XML-/JSON-file
        File xmlFile = new File(pathToXML);
        File jsonFile = new File(pathToJSON);

        // XML-Object-JSON Converter
        // Converters
        XMLConverter xmlConverter = new XMLConverterImpl();
        JSONConverter jsonConverter = new JSONConverterImpl();

        // XML to Object
        Shop xmlShop = (Shop) xmlConverter.toObject(xmlFile, Shop.class);
        String xmlShopString = xmlShop.toString();
        LOGGER.info(xmlShopString);
        // Object to XML
        String xmlString = xmlConverter.toXML(xmlShop);
        LOGGER.info(xmlString);

        // JSON to Object
        Shop jsonShop = (Shop) jsonConverter.toObject(jsonFile, Shop.class);
        String jsonShopString = jsonShop.toString();
        LOGGER.info(jsonShopString);
        // Object to JSON
        String jsonString = jsonConverter.toJSON(jsonShop);
        LOGGER.info(jsonString);

        // JSON to XML
        String convertedXMLString = xmlConverter.toXML(jsonConverter.toObject(jsonFile, Shop.class));
        LOGGER.info(convertedXMLString);
        // XML to JSON
        String convertedJSONString = jsonConverter.toJSON(xmlConverter.toObject(xmlFile, Shop.class));
        LOGGER.info(convertedJSONString);
    }
}
