package day1trebuchet;

import day1trebuchet.part1.DigitFinder;
import day1trebuchet.part2.NumberFinder;

import java.io.FileNotFoundException;

public class TrebuchetMain {

    private static final String DEFAULT_PART = "part1";
    private static final String DEFAULT_FILE = "inputFiles/day1trebuchet.txt";

    public static void main(String[] args) {

        String part = DEFAULT_PART;
        if (args.length > 0) {
            part = args[0];
        }
        String fileName = DEFAULT_FILE;
        if (args.length > 1) {
            fileName = args[1];
        }

        ValueFinder valueFinder;

        switch (part) {
            case "part1" -> valueFinder = new DigitFinder();
            case "part2" -> valueFinder = new NumberFinder();
            default -> {
                System.out.println("Invalid argument: " + part);
                System.out.println("Valid arguments are: ");
                System.out.println("\tpart1 <filename>\t calculate based on numerals only");
                System.out.println("\tpart2 <filename>\t calculate based on numerals or spelled out numbers");
                return;
            }
        }

        TrebuchetCalculator calculator = new TrebuchetCalculator(valueFinder);
        try {
            System.out.println(calculator.calculateFromFile(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }
}
