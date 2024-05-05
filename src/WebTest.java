import java.util.*;

/*  Kevin Nguyen
 *  04/25/2024
 *
 *  This program creates the fields for the results of a test. The contains methods
 *  check the test result for a matching keyword in its fields. The toString formats
 *  the test result output.
 */

public class WebTest {
    private String category;
    private String description;
    // the four web checkers
    private String googleResult;
    private String waveResult;
    private String sortSiteResult;
    private String asLintResult;

    /**
     * Constructor receives arguments for the fields above.
     *
     * @param category is the category of the web test.
     * @param googleResult is the result of the web test from Google web checker.
     * @param waveResult is the result of the web test from WAVE web checker.
     * @param sortSiteResult is the result of the web test from SortSite web checker.
     * @param asLintResult is the result of the web test from ASLint web checker.
     * @param description is the description of the web test.
     */
    public WebTest(String category, String googleResult, String waveResult, String sortSiteResult,
                   String asLintResult, String description) {
        this.category = category;
        this.description = description;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortSiteResult = sortSiteResult;
        this.asLintResult = asLintResult;
    }

    // Getter Methods

    /**
     * Gets the category of the web test.
     *
     * @return category of the web test.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the description of the web test.
     *
     * @return description of the web test.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the Google result of the web test.
     *
     * @return Google result of the web test.
     */
    public String getGoogleResult() {
        return googleResult;
    }

    /**
     * Gets the WAVE result of the web test.
     *
     * @return WAVE result of the web test.
     */
    public String getWaveResult() {
        return waveResult;
    }

    /**
     * Gets the SortSite result of the web test.
     *
     * @return SortSite result of the web test.
     */
    public String getSortSiteResult() {
        return sortSiteResult;
    }

    /**
     * Gets the ASLint result of the web test.
     *
     * @return ASLint result of the web test.
     */
    public String getAsLintResult() {
        return asLintResult;
    }

    /**
     * Formats WebTest using category, description, Google result, WAVE result,
     * SortSite result, and ASLint result.
     *
     * @return string format of WebTest.
     */
    @Override
    public String toString() {
        return category + ": " + description + " Google: " + googleResult +
                " WAVE: " + waveResult + " SortSite: " + sortSiteResult +
                " ASLint: " + asLintResult;

        // Keyboard: Alert shows for a short time
        // Google: notfound
        // WAVE: notfound
        // SortSite: notfound
        // ASLint: notfound
    }
}
