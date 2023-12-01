package day1trebuchet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrebuchetCalculator {

    private final ValueFinder valueFinder;

    public TrebuchetCalculator(ValueFinder valueFinder) {
        this.valueFinder = valueFinder;
    }

    public int calculateFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        Scanner scanner = new Scanner(file); // I didn't write this in a very testable way. I should have had Main read
                                             // the file and pass in an array or list of the lines. But then, what
        int total = 0;                       // logic would be left here? Just summing the values? I might as well put
        while (scanner.hasNextLine()) {      // all of that into Main, but then I'd probably be doing too much in Main.
            total += valueFinder.getValueForString(scanner.nextLine());
        }

        return total;
    }
}
