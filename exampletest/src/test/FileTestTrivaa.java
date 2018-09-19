import main.customer.MailServerUnavailabException;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class FileTestTrivaa {
    @Test
    public void testFileTrivaaJson() throws Exception {
        File file = new File(this.getClass().getResource("/trivaa.json").toURI());
        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .hasExtension("json")
                .hasName("trivaa.json");

        assertThat(contentOf(file))
                .startsWith("{\"");

    }

    @Test
    public void testException() throws Exception{
        Exception exception = new MailServerUnavailabException("this is a test");
        assertThat(exception)
                .hasMessage("this is a test")
                .isInstanceOf(MailServerUnavailabException.class)
                .hasMessageContaining("test");

    }
}
