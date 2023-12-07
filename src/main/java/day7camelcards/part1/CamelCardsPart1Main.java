package day7camelcards.part1;

import day7camelcards.HandParser;
import utils.ResultPrinter;

public class CamelCardsPart1Main {
    private static final String FILE_NAME = "inputFiles/day7camelcards";

    public static void main(String[] args) {
        HandParser parser = new HandParser();
        WinningsCalculator calculator = new WinningsCalculator();

        ResultPrinter.printResult(FILE_NAME, inputLines -> calculator.calculateWinnings(parser.parseHands(inputLines)));
    }
}
