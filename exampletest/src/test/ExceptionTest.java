import main.customer.InfoService;
import main.customer.MailServerUnavailabException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExceptionTest {

    private InfoService infoService = new InfoService();

    @Test
    public void testTryCatchException() {
        try {
            infoService.sendWeeklyMail();

        } catch (Exception ex) {
            assertTrue(ex instanceof MailServerUnavailabException);
            assertEquals("Mail Server Error",ex.getMessage());
        }
    }

    @Test(expected = MailServerUnavailabException.class)
    public void testExpectedException(){
        infoService.sendWeeklyMail();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRuleException() throws Exception{
        thrown.expect(MailServerUnavailabException.class);
        thrown.expectMessage("Mail Server Error");
        infoService.sendWeeklyMail();
    }
}
