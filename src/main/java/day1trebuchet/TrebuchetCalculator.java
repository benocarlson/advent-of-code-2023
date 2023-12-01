package day1trebuchet;

import day1trebuchet.part1.DigitFinder;

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

        Scanner scanner = new Scanner(file);

        int total = 0;
        while (scanner.hasNextLine()) {
            total += valueFinder.getValueForString(scanner.nextLine());
        }

        return total;
    }
}
