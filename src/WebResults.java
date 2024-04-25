import java.util.*;
import java.io.*;

public class WebResults {
    public static void main(String[] args) {
        read("data/CheckersResults.txt");
    }
    public static void read(String fileName) {

        try (Scanner input = new Scanner(new File(fileName))) {
            
            //input.useDelimiter(" "); // Splits and identifies new data by a space
            
            //Set<String> results = new HashSet<>();
            List<test> results = new ArrayList<test>();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(" ");
                String one = data[0];
                String two = data[1];
                String three = data[2];
                String four = data[3]; 
                String five = data[4];
                String six = data[5];  

                test t = new test(one, two, three, four, five, six);
                results.add(t);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
