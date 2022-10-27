import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;


public class CatTest {

    @Test
    public void CatCheckGetSoundTest() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        System.out.println(cat.getSound());
        Assert.assertEquals("Неправильно, должно быть 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void CatCheckGetFoodTestWithtMock() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        System.out.println(cat.getFood());
        String eat[] = {"Животные", "Птицы", "Рыба"};
        String result = Arrays.toString(eat);
        Assert.assertEquals(result, cat.getFood().toString());

    }
    @Test
    public void CatCheckGetFoodTest() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        System.out.println(cat.getFood());
        String eat[] = {"Животные", "Птицы", "Рыба"};
        String result = Arrays.toString(eat);
        Assert.assertEquals(result, cat.getFood().toString());

    }
}


