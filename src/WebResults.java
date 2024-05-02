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
    private Set<String> tests;
    private int testCount = 0;

    public WebResults(String filename) {
        tests = new HashSet<>();
        read(filename);
    }

    private void read(String fileName) {
        try (Scanner input = new Scanner(new File(fileName))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(" ", 6);
                if (data.length == 6) {
                    String testString = String.join(" ", data); // Store data as a single string
                    tests.add(testString);
                    testCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    public int numTests() {
        return testCount;
    }

    public void showTestResults(String detail) {
        int testMatches = 0;
        String detailLower = detail.toLowerCase();
        for (String test : tests) {
            if (test.toLowerCase().contains(detailLower)) {
                System.out.println(test);
                testMatches++;
            }
        }
        System.out.println("Total tests matching: " + testMatches);
    }

    public void showByCategory(String category) {
        int categoryMatches = 0;
        String categoryLower = category.toLowerCase();
        for (String test : tests) {
            if (test.toLowerCase().contains(categoryLower)) {
                System.out.println(test);
                categoryMatches++;
            }
        }
    }

    public void showAllFailed() {
        int failCount = 0;
        for (String test : tests) {
            if (test.toLowerCase().contains("notfound")) {
                System.out.println(test);
                failCount++;
            }
        }
    }

    public int numPass(String checker, String category) {
        int passCount = 0;
        String checkerLower = checker.toLowerCase();
        String categoryLower = category.toLowerCase();
        for (String test : tests) {
            if (test.toLowerCase().contains("error") || test.toLowerCase().contains("error_paid")) {
                passCount++;    
                }
            }    
        return passCount;
    }

    public void showAll() {
        for (String test : tests) {
            System.out.println(test);
        }
    }

    public static void main(String[] args) {
        WebResults results = new WebResults("data/CheckersResults.txt");

        System.out.println(results.numPass("Goog", ""));
//        results.showAll();
//        System.out.println("Number of tests: " + results.numTests());
//        results.showTestResults("colour");
    }
}

/**
 * Output:
 * Keyboard: Dropdown navigation - only the top level items receive focus Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Keyboard trap Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Keyboard focus assigned to a non focusable element using tabindex=0 Google: notfound WAVE: manual SortSite: notfound ASLint: notfound
 * Keyboard: Lightbox - ESC key doesn't close the lightbox Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Link with a role=button does not work with space bar Google: notfound WAVE: notfound SortSite: notfound ASLint: error
 * Keyboard: Keyboard focus is not indicated visually Google: notfound WAVE: notfound SortSite: error ASLint: error
 * Keyboard: Lightbox - focus is not moved immediately to lightbox Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Alert shows for a short time Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Accesskey attribute used Google: notfound WAVE: warning SortSite: notfound ASLint: notfound
 * Keyboard: Lightbox - focus is not retained within the lightbox Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Concertina items don't get keyboard focus Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Focus order in wrong order Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Lightbox - close button doesn't receive focus Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Tabindex greater than 0 Google: error WAVE: warning SortSite: notfound ASLint: warning
 * Keyboard: Tooltips don't receive keyboard focus Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Keyboard: Fake button is not keyboard accessible Google: notfound WAVE: notfound SortSite: notfound ASLint: notfound
 * Total tests in category: 16
 */