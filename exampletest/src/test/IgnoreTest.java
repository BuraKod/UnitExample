import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTest {
    @Test
    public void testHello() {
        System.out.println("Hello");
    }

    @Ignore("This method cancel")
    @Test
    public void testHello2() {
        System.out.println("Hello 2");
    }
}
