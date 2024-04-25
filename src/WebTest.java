import java.util.*;

public class WebTest {
    private String category;
    private String description;
    private String googleResult;
    private String waveResult;
    private String sortSiteResult;
    private String asLintResult;

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

    public String toString() {
        return "Keyboard: " + getCategory() + " Google: " + getGoogleResult() + " WAVE: " +
                getWaveResult() + " SortSite: " + getSortSiteResult() + " ASLint: " +
                getAsLintResult();
        //Keyboard: Alert shows for a short time
        // Google: notfound
        // WAVE: notfound
        // SortSite: notfound
        // ASLint: notfound
    }

}
