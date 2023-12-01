package day1trebuchet;

import day1trebuchet.part1.DigitFinder;
import day1trebuchet.part2.NumberFinder;

import java.io.FileNotFoundException;

public class TrebuchetMain {

    private static final String DEFAULT_PART = "part1";

    public static void main(String[] args) {

        String part = DEFAULT_PART;
        if (args.length > 0) {
            part = args[0];
        }

        ValueFinder valueFinder;

        switch (part) {
            case "part1" -> valueFinder = new DigitFinder();
            case "part2" -> valueFinder = new NumberFinder();
            default -> {
                System.out.println("Invalid argument: " + part);
                System.out.println("Valid arguments are [part1] and [part2]");
                return;
            }
        }

        String fileName = "inputFiles/day1trebuchet.txt";
        TrebuchetCalculator calculator = new TrebuchetCalculator(valueFinder);
        try {
            System.out.println(calculator.calculateFromFile(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }
}
