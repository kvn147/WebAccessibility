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

    public WebResults(String filename) {
        tests = new HashSet<>();

        read(filename);
    }

    public Set<WebTest> getTests() {
        return tests;
    }

    private void read(String fileName) {
        try (Scanner input = new Scanner(new File(fileName))) {


            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(" ", 6);
                if (data.length == 6) {
                    WebTest test = new WebTest(data[0], data[1], data[2], data[3],
                            data[4], data[5]);
                    tests.add(test);
                    testCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    public int numTests(){
        return testCount;
    }

    public void showTestResults(String detail) {
        int testMatches = 0;
        for (WebTest test : this.tests) {
            if (test.containsDetail(detail)) {
                System.out.println(test);
                testMatches++;
            }
        }
        System.out.println("Total tests matching: " + testMatches);
    }

    public void showByCategory(String detail) {
        int categoryMatches = 0;
        for (WebTest test : this.tests) {
            if (test.containsCategory(detail)) {
                System.out.println(test);
                categoryMatches++;
            }
        }
        System.out.println("Total tests in category: " + categoryMatches);
    }

    public void showAllFailed() {
        int failMatches = 0;
        for (WebTest test : this.tests) {
            if (test.containsDetail("notfound")) {
                System.out.println(test);
                failMatches++;
            }
        }
        System.out.println("Total tests failed: " + failMatches);
    }

    public static void main(String[] args) {
        WebResults results = new WebResults("data/CheckersResults.txt");

//        for (WebTest test : results.getTests()) {
//            System.out.println(test);
//        }
//
//        results.showTestResults("colour");

        results.showByCategory("Key");

//        results.showAllFailed();

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