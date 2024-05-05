import java.util.*;
import java.io.*;

/*  Kevin Nguyen
 *  04/25/2024
 *
 *  This program tokenizes the data by category, description, and web checkers
 *  it reads from a file. It outputs the number of tests, test results matches
 *  of detail and/or category, failed tests, and number of errors of a given
 *  web checker and category.
 */

public class WebResults {
    private Set<WebTest> tests;
    private int testCount = 0;

    /**
     * Constructs a WebResults object called tests that is a Hash Set and reads from a file.
     *
     * @param filename The file name it will read
     */
    public WebResults(String filename) {
        tests = new HashSet<>();
        read(filename);
    }

    /**
     * Splits the file by web test, and splits each web test's category, description,
     * and its web checker results. Then stores it in tests.
     *
     * @param fileName The file name it will read and split the web tests
     */
    private void read(String fileName) {
        try (Scanner input = new Scanner(new File(fileName))) {

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(" ", 6);

                if (data.length == 6) {
                    String category = data[0];
                    String googleResult = data[1];
                    String waveResult = data[2];
                    String sortSiteResult = data[3];
                    String asLintResult = data[4];

                    // StringBuilder for the special case of description
                    StringBuilder descriptionBuilder = new StringBuilder();
                    for (int i = 5; i < data.length; i++) {
                        descriptionBuilder.append(data[i]);
                        if (i < data.length - 1) {
                            descriptionBuilder.append(" "); // Add space between words
                        }
                    }
                    String description = descriptionBuilder.toString();

                    tests.add(new WebTest(category, googleResult, waveResult, sortSiteResult,
                            asLintResult, description));
                    testCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    /**
     * Retrieves the number of web tests.
     *
     * @return the number of web tests in file.
     */
    public int numTests() {
        return testCount;
    }

    /**
     * Counts the web tests that match the specified details or description.
     *
     * @param detail is the details or description to match.
     */
    public void showTestResults(String detail) {
        int testMatches = 0;
        String detailLower = detail.toLowerCase();

        for (WebTest test : tests) {
            String testDescription = test.getDescription().toLowerCase();
            String testCategory = test.getCategory().toLowerCase();

            if (testDescription.contains(detailLower)) {
                System.out.println(test);
                testMatches++;
            }
        }
        System.out.println("Total tests matching: " + testMatches);
    }

    /**
     * Counts the number of web tests that match the specified category.
     *
     * @param category is the category to match.
     */
    public void showByCategory(String category) {
        int categoryMatches = 0;
        String categoryLower = category.toLowerCase();

        for (WebTest test : tests) {
            String testCategory = test.getCategory().toLowerCase();

            if (testCategory.contains(categoryLower)) {
                System.out.println(test);
                categoryMatches++;
            }
        }
        System.out.println();
        System.out.println("Total tests in category: " + categoryMatches);
    }

    /**
     * Prints the number of web tests that have all their web checker results as "notfound"
     */
    public void showAllFailed() {
        int failCount = 0;

        for (WebTest test : tests) {
            if (Objects.equals(test.getGoogleResult(), "notfound") &&
                    Objects.equals(test.getWaveResult(), "notfound") &&
                    Objects.equals(test.getSortSiteResult(), "notfound") &&
                    Objects.equals(test.getAsLintResult(), "notfound")) {
                failCount++;
                System.out.println(test);
            }


            }
        System.out.println(failCount);
    }

    /**
     * Counts the number of web checker results that are error or error_plaid given the
     * specified web checker and specified category it is looking at.
     *
     * @param checker is the web checker such as Google Result that is checked.
     * @param category is the category that is checked.
     * @return the number of web tests that had the web checker result be error or error_plaid.
     */
    public int numPass(String checker, String category) {
        int passCount = 0;

        final String GOOGLE = "google result";
        final String WAVE = "wave result";
        final String SORT = "sortsite result";
        final String ASLINT = "aslint result";

        // Convert checker and category to lowercase for case insensitivity
        String checkerLower = checker.toLowerCase();
        String categoryLower = category.toLowerCase();

        for (WebTest test : tests) {
            String testCategory = test.getCategory().toLowerCase();

            if (testCategory.contains(categoryLower)) {
                if (GOOGLE.contains(checkerLower) &&
                        (test.getGoogleResult().equalsIgnoreCase("error") ||
                                test.getGoogleResult().equalsIgnoreCase("error_plaid"))) {
                    passCount++;
                }
                else if (WAVE.contains(checkerLower) && (test.getWaveResult().equalsIgnoreCase("error") ||
                        test.getWaveResult().equalsIgnoreCase("error_plaid"))) {

                    passCount++;
                }
                else if (SORT.contains(checkerLower) && (test.getSortSiteResult().equalsIgnoreCase("error") ||
                        test.getSortSiteResult().equalsIgnoreCase("error_plaid"))) {

                    passCount++;
                }

                else if (ASLINT.contains(checkerLower) && (test.getAsLintResult().equalsIgnoreCase("error") ||
                        test.getAsLintResult().equalsIgnoreCase("error_plaid"))) {

                    passCount++;
                }
            }
        }
        return passCount;
    }

    /**
     * Prints all tests in the web test set.
     */
    public void showAll() {
        for (WebTest test : tests) {
            System.out.println(test);
        }
    }

    public static void main(String[] args) {
        WebResults results = new WebResults("data/CheckersResults.txt");

//        results.showAll();
//        System.out.println("Number of tests: " + results.numTests());
//        results.showTestResults("Colour");
//     results.showByCategory("key");
//        results.showAllFailed();
        System.out.println(results.numPass("lint", "htm"));
    }
}

/**
 * Output:
 * 2
 */