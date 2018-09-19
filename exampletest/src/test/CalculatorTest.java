
import main.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testSum() {

        // TODO: 12.09.2018  Elimde şu var (Given) onunla şunu yapmak istiyorum (When) sonucunda şunu istiyorum (Then)

        //  Given (Ön Hazırlık)
        Calculator calculator = new Calculator();
        int n1 = 5;
        int n2 = 10;

        // When (Method İşlemleri)

        int sum = calculator.sum(n1, n2);

        // Then (Sonucu Kontrol Et)

        assertEquals(15, sum);

    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        // Test sınıfımızda assert ile bir hata ile karşılaşırsa geri kalan line 'lar da hiç compile edilmeden hata verir.
        assertEquals(15, calculator.subTraction(15, 0));
        assertEquals(-15, calculator.subTraction(0, 15));
        assertEquals(20, calculator.subTraction(50, 30));
        // Bu yüzden senaryoları tek tek yazmak ve yeni metodlar halinde testlerimizi yapmalıyız.
    }
}
