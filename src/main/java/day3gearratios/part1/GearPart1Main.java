package day3gearratios.part1;

import utils.ResultPrinter;

public class GearPart1Main {
    private static final String INPUT_FILE = "inputFiles/day3gearratios";
    public static void main(String[] args) {
        ResultPrinter.printResult(INPUT_FILE, inputLines -> new PartNumberParser().parsePartNumbers(inputLines).stream().mapToInt(val -> val).sum());
    }
}
