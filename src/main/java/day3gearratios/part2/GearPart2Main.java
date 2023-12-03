package day3gearratios.part2;

import utils.FileUtils;
import utils.ResultPrinter;

import java.io.FileNotFoundException;
import java.util.List;

public class GearPart2Main {

    public static final String FILE_NAME = "inputFiles/day3gearratios";

    public static void main(String[] args) {
        ResultPrinter.printResult(FILE_NAME, inputLines -> new GearCalculator(new GearParser()).calculateSumOfGearRatios(inputLines));
    }
}
