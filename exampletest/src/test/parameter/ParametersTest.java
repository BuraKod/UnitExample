package parameter;

import main.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParametersTest {

    private Calculator calculator = new Calculator();

    public ParametersTest(int weight, int height, int sumM2Suqare) {
        this.weight = weight;
        this.height = height;
        this.sumM2Suqare = sumM2Suqare;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 2, 20},
                {20, 2, 40},
                {3, 2, 6},
                {2, 8, 16},
                {7, 2, 14}}
        );
    }

    private int weight, height, sumM2Suqare;

    @Test
    public void testM2Suqare() throws Exception {
        //assertEquals(20,calculator.m2Suqare(10,2));
        //assertEquals(40,calculator.m2Suqare(20,2));

        //Paremeterized
        assertEquals(sumM2Suqare, calculator.m2Suqare(weight, height));


    }
}
