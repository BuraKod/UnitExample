import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)

@Suite.SuiteClasses({
        ExceptionTest.class,
        CalculatorTest.class,
        HamcrestTest.class,
        IgnoreTest.class,
        FileTestTrivaa.class,
        LombokTest.class
})
public class SuiteTest {
}
