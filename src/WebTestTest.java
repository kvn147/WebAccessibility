import org.junit.juputer.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class WebTestTest {

    @Test
    void testCategory() {
        WebTest test = new WebTest("Content", "", "", "", "", "");
        assertEquals("Content", test.getCategory());
    }
}
