package parameter;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ParametersTest2 {
    private Calculator calculator = new Calculator();


    @Test
    @Parameters({"10,2,20","20,7,140"})
    public void testM2Square(int weight,int height,int sumM2Square) {
        assertEquals(sumM2Square,calculator.m2Suqare(weight,height));
    }
}
