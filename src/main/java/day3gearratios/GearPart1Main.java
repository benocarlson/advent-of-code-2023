package day3gearratios;

import utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class GearPart1Main {
    private static final String INPUT_FILE = "inputFiles/day3gearratios";
    public static void main(String[] args) {
        try {
            List<String> inputLines = FileUtils.getLinesFromFile(INPUT_FILE);
            int sum = new PartNumberParser().parsePartNumbers(inputLines).stream().mapToInt(val -> val).sum();

            System.out.println("Result: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + INPUT_FILE);
        }
    }
}
