import java.util.*;
import java.io.*;

public class WebResults {
    public static void main(String[] args) {
        read("data/CheckersResults.txt");
    }
    public static void read(String fileName) {

        try (Scanner input = new Scanner(new File(fileName))) {
            input.useDelimiter(" "); // Splits and identifies new data by a space
            Set<String> results = new HashSet<>();
            while (input.hasNext()) {

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
