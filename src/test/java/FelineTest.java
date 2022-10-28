import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FelineTest {

    @Test
    public void FelineGetFamilyCheckTest() {
        Feline feline = new Feline();
        System.out.println(feline.getFamily());
        Assert.assertEquals("Неправильно, должно быть 'Кошачьи'", "Кошачьи", feline.getFamily());
    }

    @Test
    public void FelineGetKittensCheckTest() {
        Feline feline = new Feline();
        System.out.println(feline.getKittens());
        Assert.assertEquals("Неправильно, должно быть '1'", 1, feline.getKittens());
    }

    @Test
    public void FelineGetKittensIntCheckTest() {
        Feline feline = new Feline();
        System.out.println(feline.getKittens(5));
        Assert.assertEquals("Неправильно, должно быть '5'", 5, feline.getKittens(5));
    }

    @Test
    public void FelineEatMeatCheckTest() throws Exception {
        Feline feline = new Feline();
        List<String> eat = List.of("Животные", "Птицы", "Рыба");
        System.out.println(feline.eatMeat());
        Assert.assertEquals("Некорректный тип питания!", eat, feline.eatMeat());
    }

    @Test
    public void FelineGetFoodCheckTest() throws Exception {
        Feline feline = new Feline();
        String[] eat = {"Животные", "Птицы", "Рыба"};
        String result = Arrays.toString(eat);
        Assert.assertEquals(result, feline.getFood("Хищник").toString());
    }
}
