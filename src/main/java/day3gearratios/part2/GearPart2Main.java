package day3gearratios.part2;

import utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class GearPart2Main {

    public static final String FILE_NAME = "inputFiles/day3gearratios";

    public static void main(String[] args) {
        try {
            List<String> inputLines = FileUtils.getLinesFromFile(FILE_NAME);
            GearCalculator calculator = new GearCalculator(new GearParser());
            int result = calculator.calculateSumOfGearRatios(inputLines);

            System.out.println("Result: " + result);

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + FILE_NAME);
        }
    }
}
