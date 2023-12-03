package day3gearratios.part1;

import utils.FileUtils;
import utils.PuzzleSolver;
import utils.ResultPrinter;

import java.io.FileNotFoundException;
import java.util.List;

public class GearPart1Main {
    private static final String INPUT_FILE = "inputFiles/day3gearratios";
    public static void main(String[] args) {
        ResultPrinter.printResult(INPUT_FILE, inputLines -> new PartNumberParser().parsePartNumbers(inputLines).stream().mapToInt(val -> val).sum());
    }
}
