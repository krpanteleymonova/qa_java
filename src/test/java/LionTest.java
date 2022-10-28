import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String gender;
    private final boolean isMan;

    public LionTest(String gender, boolean isMan) {
        this.gender = gender;
        this.isMan = isMan;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Feline feline;

    @Parameterized.Parameters
    public static Object[][] getGender() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionDoesHaveManeCheckTest() throws Exception {
            Lion lion = new Lion(gender, feline);
            System.out.println(isMan);
            System.out.println(lion.doesHaveMane());
            Assert.assertEquals(isMan, lion.doesHaveMane());
    }

    @Test
    public void lionGetKittensCheckTest() throws Exception {
            Lion lion = new Lion(gender, feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            System.out.println(lion.getKittens());
            Assert.assertEquals("Неправильно, должно быть '1'", 1, lion.getKittens());
    }

    @Test
    public void lionGetFoodCheckTest() throws Exception {
            Lion lion = new Lion(gender, feline);
            List<String> eat = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(eat);
            System.out.println(lion.getFood());
            Assert.assertEquals("Некорректный тип питания!", eat, lion.getFood());
    }

    @Test
    public void lionGetFoodCheckTestщдв() {
        Exception exception;
        try {
            Lion lion = new Lion(gender, feline);

        } catch (Exception ex) {
            exception = ex;
            System.out.println(exception.getMessage());
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
    @Test(expected = Exception.class)
    public void constructorThrowsExceptionOnUnsupportedSex() throws Exception {
        Lion lion = new Lion("Неизвестно", feline);
    }

    @Test
    public void constructorThrowsExceptionOnUnsupportedSexMessage() {
        Exception exception = null;
        try {
            Lion lion = new Lion("Неизвестно", feline);
        } catch (Exception ex) {
            exception = ex;
            System.out.println(exception.getMessage());
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
