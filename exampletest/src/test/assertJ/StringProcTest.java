package assertJ;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class StringProcTest {

    private List<String> citysTurkeyList = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir"));
    private List<String> citysEuropeList = new ArrayList<String>(Arrays.asList("Lisbon","Paris" ,"London","Amsterdam"));


    @Test
    public void testStringProc() throws Exception {
        String text1 = "Istanbul";

        assertThat(text1)
                .isEqualTo("Istanbul")
                .startsWith("Ist")
                .endsWith("bul")
                .contains("tan")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("bur");

    }

    @Test
    public void testListProc() {
        List<String> citysTurkeyList1 = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir"));

        assertThat(citysTurkeyList1).describedAs("bu bir hata")
                          .contains("Ankara")
                          .doesNotContain("Bursa")
                          .containsExactly("Istanbul","Ankara","Izmir")
                          .doesNotHaveDuplicates();

        // Listemde sadece türk şehirler olsun
        List<String> citysTurkeyList2 = new ArrayList<String>(Arrays.asList("Istanbul","Ankara","Izmir"));

        assertThat(citysTurkeyList2)
                .have(citysTurkey());

        // Listemde sadece yabancı şehirler olsun
        List<String> citysEuropeList1 = new ArrayList<String>(Arrays.asList("Lisbon","Paris","London","Amsterdam"));

        assertThat(citysEuropeList1)
                .have(citysEurope());

        // Listemde 2 Türk 3 de Yabancı şehir olsun.
        List<String> citysMixed = new ArrayList<String>(Arrays.asList("Lisbon","Istanbul","Ankara","Amsterdam","Paris"));
        assertThat(citysMixed)
                .haveExactly(2,citysTurkey())
                .haveExactly(3,citysEurope());
    }

    private Condition<? super String> citysEurope() {
        return new Condition<String>() {
            @Override
            public boolean matches(String value) {
                return citysEuropeList.contains(value);
            }
        };
    }

    private Condition<? super String> citysTurkey() {
        return new Condition<String>() {
            @Override
            public boolean matches(String value) { // Bu method doğru veya yanlış değeri geri verir.
                return citysTurkeyList.contains(value);
            }
        };

    }
}
