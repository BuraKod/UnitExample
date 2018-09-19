import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HamcrestTest {

    @Test
    public void testMatcher1() {
        String text1 = "Mustafa";
        String text2 = "Kemal";
        assertEquals("Mustafa", text1);
        assertThat(text1, is(equalTo("Mustafa")));
        assertThat(text1, is(notNullValue()));
        assertThat(text1, containsString("afa"));
        assertThat(text1, anyOf(containsString("afa"), containsString("mus")));

    }

    @Test
    public void testMatcherList() {
        List<String> citys = new ArrayList<String>(Arrays.asList("Istanbul", "Ankara", "Bursa"));

        assertThat(citys, hasItem("Istanbul"));
        assertThat(citys, hasItems("Istanbul", "Ankara"));
        assertThat(citys, allOf(hasItems("Istanbul","Ankara"), not(hasItem("Izmir"))));
        assertThat(citys, either(hasItems("Istanbul","Ankara")).or(not(hasItem("Izmir"))));

    }
}
