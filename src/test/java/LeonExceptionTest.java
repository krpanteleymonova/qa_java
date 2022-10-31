import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LeonExceptionTest {

    private String gender;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Feline feline;

    @Test
    public void constructorThrowsExceptionOnUnsupportedSexMessage() {
        Exception exception = null;
        try {
            Lion lion = new Lion("Неизвестно", feline);
        } catch (Exception ex) {
            exception = ex;

        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}




