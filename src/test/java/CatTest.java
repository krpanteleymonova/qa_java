import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;

    @Test
    public void CatGetSoundCheckTest() {
        Cat cat = new Cat(feline);
        System.out.println(cat.getSound());
        assertEquals("Неправильно, должно быть 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void CatGetFoodCheckTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> eat = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(eat);
        System.out.println(cat.getFood());
        assertEquals("Eat is incorrect!", eat, cat.getFood());
    }
}


