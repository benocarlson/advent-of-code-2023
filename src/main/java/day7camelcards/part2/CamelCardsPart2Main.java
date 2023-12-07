package day7camelcards.part2;

import day7camelcards.HandParser;
import day7camelcards.part1.WinningsCalculator;
import utils.ResultPrinter;

public class CamelCardsPart2Main {
    private static final String FILE_NAME = "inputFiles/day7camelcards";

    public static void main(String[] args) {
        HandParser parser = new HandParser();
        WinningsCalculator calculator = new WinningsCalculator();

        ResultPrinter.printLongResult(FILE_NAME, inputLines -> calculator.calculateWinnings(parser.parseHandsWithJokers(inputLines)));
    }
}
