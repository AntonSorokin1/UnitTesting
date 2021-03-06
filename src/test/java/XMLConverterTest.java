import entity.Category;
import entity.Product;
import entity.Shop;
import entity.SubCategory;
import example.services.FileService;
import example.services.PropertiesService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.XMLConverter;
import util.impl.XMLConverterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class XMLConverterTest {
    private XMLConverter subject;
    private Shop shop;
    private String shopXML;

    @Before
    public void beforeMethod() {
        this.subject = new XMLConverterImpl();
        this.shop = new Shop(Arrays.asList(
                new Category("kitchen", Arrays.asList(
                        new SubCategory("technique", Arrays.asList(
                                new Product("BIRUSA", "AB123", new GregorianCalendar(2020, Calendar.DECEMBER, 31), "Red", 100.1, 0, null),
                                new Product("BIRUSA", "AC123", new GregorianCalendar(2020, Calendar.DECEMBER, 30), "Green", 100.2, 15, null),
                                new Product("BIRUSA", "AD123", new GregorianCalendar(2020, Calendar.DECEMBER, 29), "Blue", 100.3, 0, null)
                        )),
                        new SubCategory("hardware", Arrays.asList(
                                new Product("DRUZHBA", "AE234", new GregorianCalendar(2020, Calendar.NOVEMBER, 28), "Red", 200.4, 20, null),
                                new Product("DRUZHBA", "AF234", new GregorianCalendar(2020, Calendar.NOVEMBER, 27), "Green", 200.5, 0, null),
                                new Product("DRUZHBA", "AG234", new GregorianCalendar(2020, Calendar.NOVEMBER, 26), "Blue", 200.6, 21, null)
                        ))
                )),
                new Category("bathroom", Arrays.asList(
                        new SubCategory("technique", Arrays.asList(
                                new Product("BOSH", "BC345", new GregorianCalendar(2019, Calendar.OCTOBER, 25), "Red", 1100.1, 5, null),
                                new Product("BOSH", "BD345", new GregorianCalendar(2019, Calendar.OCTOBER, 24), "Green", 1100.2, 0, null),
                                new Product("BOSH", "BE345", new GregorianCalendar(2019, Calendar.OCTOBER, 23), "Blue", 1100.3, 3, null)
                        )),
                        new SubCategory("hardware", Arrays.asList(
                                new Product("SHELLY", "BF456", new GregorianCalendar(2019, Calendar.SEPTEMBER, 22), "Red", 1200.4, 6, null),
                                new Product("SHELLY", "BG456", new GregorianCalendar(2019, Calendar.SEPTEMBER, 21), "Green", 1200.5, 10, null),
                                new Product("SHELLY", "BH456", new GregorianCalendar(2019, Calendar.SEPTEMBER, 20), "Blue", 1200.6, 0, null)
                        ))
                )),
                new Category("livingRoom", Arrays.asList(
                        new SubCategory("technique", Arrays.asList(
                                new Product("SONY", "CD567", new GregorianCalendar(2018, Calendar.AUGUST, 19), "Red", 2100.1, 0, null),
                                new Product("SONY", "CE567", new GregorianCalendar(2018, Calendar.AUGUST, 18), "Green", 2100.2, 0, null),
                                new Product("SONY", "CF567", new GregorianCalendar(2018, Calendar.AUGUST, 17), "Blue", 2100.3, 0, null)
                        )),
                        new SubCategory("hardware", Arrays.asList(
                                new Product("ATLANT", "CG678", new GregorianCalendar(2018, Calendar.JULY, 16), "Red", 2200.4, 1, null),
                                new Product("ATLANT", "CH678", new GregorianCalendar(2018, Calendar.JULY, 15), "Green", 2200.5, 2, null),
                                new Product("ATLANT", "CI678", new GregorianCalendar(2018, Calendar.JULY, 14), "Blue", 2200.6, 3, null)
                        ))
                ))
        ));
        String pathToXML = PropertiesService.getProperty("pathToXML");
        InputStream xmlFileInputStream = FileService.getInputStream(pathToXML);

        StringBuilder sbXML = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(xmlFileInputStream))) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                sbXML.append(temp).append('\n');
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.shopXML = sbXML.toString();
    }

    @After
    public void afterMethod() {

    }

    @Test
    public void toXML() {
        String expected = shopXML;
        String result = subject.toXML(shop);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void toObjectFromString() {
        String expected = this.shop.toString();
        String result = subject.toObject(shopXML, Shop.class).toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void toObjectFromStream() {
        String pathToXML = PropertiesService.getProperty("pathToXML");
        InputStream xmlFileInputStream = FileService.getInputStream(pathToXML);

        String expected = this.shop.toString();
        String result = subject.toObject(xmlFileInputStream, Shop.class).toString();
        Assert.assertEquals(expected, result);
    }
}
