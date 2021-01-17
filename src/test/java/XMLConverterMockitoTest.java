import entity.Shop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import util.XMLConverter;

public class XMLConverterMockitoTest {
    @Mock
    private XMLConverter subject;
    @InjectMocks
    private Shop shop;
    @InjectMocks
    private String shopXML;

    @Before
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void afterMethod() {

    }

    @Test
    public void toXML() {
        Mockito.when(subject.toXML(shop)).thenReturn(shopXML);
        Assert.assertEquals(shopXML, subject.toXML(shop));
    }

    @Test
    public void toObjectFromString() {
        Mockito.when(subject.toObject(shopXML, Shop.class)).thenReturn(shop);
        Assert.assertEquals(shop, subject.toObject(shopXML, Shop.class));
    }
}
