import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WebTestTest {

    @Test
    void testCategory() {
        WebTest test = new WebTest("Content",
                "", "", "", "", "");
        assertEquals("Content", test.getCategory());
    }

    @Test
    void testDescription() {
        WebTest test = new WebTest("",
                "", "", "", "", "input");
        assertEquals("input", test.getDescription());
    }

    @Test
    void testGoogleResult() {
        WebTest test = new WebTest("",
                "notfound", "", "", "", "");
        assertEquals("notfound", test.getGoogleResult());
    }

    @Test
    void testWaveResult() {
        WebTest test = new WebTest("",
                "", "error", "", "", "");
        assertEquals("error", test.getWaveResult());
    }

    @Test
    void testSortSiteResult() {
        WebTest test = new WebTest("",
                "", "", "error", "", "");
        assertEquals("error", test.getSortSiteResult());
    }

    @Test
    void testAsLintResult() {
        WebTest test = new WebTest("",
                "", "", "", "notfound", "");
        assertEquals("notfound", test.getAsLintResult());
    }
}