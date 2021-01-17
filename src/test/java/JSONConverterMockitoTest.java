import entity.Shop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import util.JSONConverter;

public class JSONConverterMockitoTest {
    @Mock
    private JSONConverter subject;
    @InjectMocks
    private Shop shop;
    @InjectMocks
    private String shopJSON;

    @Before
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void afterMethod() {

    }

    @Test
    public void toJSON() {
        Mockito.when(subject.toJSON(shop)).thenReturn(shopJSON);
        Assert.assertEquals(shopJSON, subject.toJSON(shop));
    }

    @Test
    public void toObjectFromString() {
        Mockito.when(subject.toObject(shopJSON, Shop.class)).thenReturn(shop);
        Assert.assertEquals(shop, subject.toObject(shopJSON, Shop.class));
    }
}
