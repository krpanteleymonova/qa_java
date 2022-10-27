import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class LionTest {
    private String gender;

    public LionTest(String gender) {
        this.gender = gender;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getGender() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
                //   { "Неизвестно"},
        };
    }

    @Test
    public void LionCheckDoesHaveManeTest() throws Exception {
        if (gender == "Самец") {
            Feline feline = new Feline();
            Lion lion = new Lion(gender, feline);
            System.out.println(lion.doesHaveMane());
            Assert.assertTrue("Неправильно, должно быть 'true'", lion.doesHaveMane());
        } else if (gender == "Самка") {
            Feline feline = new Feline();
            Lion lion = new Lion(gender, feline);
            System.out.println(lion.doesHaveMane());
            Assert.assertFalse("Неправильно, должно быть 'false'", lion.doesHaveMane());
        } else {
            Exception exception = null;
            try {
                Feline feline = new Feline();
                Lion lion = new Lion(gender, feline);
                System.out.println(lion.doesHaveMane());
            } catch (Exception ex) {
                exception = ex;
            }
            System.out.println(exception.getMessage());
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void LionCheckGetKittensTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        System.out.println(lion.getKittens());
        Assert.assertEquals("Неправильно, должно быть '1'", 1, lion.getKittens());
    }

    @Test
    public void LionCheckGetFoodTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        System.out.println(lion.getFood());
        String eat[] = {"Животные", "Птицы", "Рыба"};
        String result = Arrays.toString(eat);
        Assert.assertEquals(result, lion.getFood().toString());
    }
}
