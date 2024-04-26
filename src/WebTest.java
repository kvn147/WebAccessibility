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

    // constructor receives arguments for the fields above
    public WebTest(String category, String googleResult, String waveResult, String sortSiteResult,
                   String asLintResult, String description) {
        this.category = category;
        this.description = description;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortSiteResult = sortSiteResult;
        this.asLintResult = asLintResult;
    }

    // Getter Method
    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getGoogleResult() {
        return googleResult;
    }

    public String getWaveResult() {
        return waveResult;
    }

    public String getSortSiteResult() {
        return sortSiteResult;
    }

    public String getAsLintResult() {
        return asLintResult;
    }

    public boolean containsDetail(String detail) {
        String lowerDetail = detail.toLowerCase();
        return category.toLowerCase().contains(lowerDetail) ||
                description.toLowerCase().contains(lowerDetail) ||
                googleResult.toLowerCase().contains(lowerDetail) ||
                waveResult.toLowerCase().contains(lowerDetail) ||
                sortSiteResult.toLowerCase().contains(lowerDetail) ||
                asLintResult.toLowerCase().contains(lowerDetail);
    }

    public boolean containsCategory(String detail) {
        String lowerDetail = detail.toLowerCase();
        return category.toLowerCase().contains(lowerDetail);
    }

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
