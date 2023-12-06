package day6waitforit.part2;

import day6waitforit.RaceParser;
import day6waitforit.part1.FactorCounter;
import utils.ResultPrinter;

public class RacePart2Main {
    private static final String FILE_NAME = "inputFiles/day6waitforit";
    public static void main(String[] args) {
        FactorCounter counter = new FactorCounter();
        RaceParser parser = new RaceParser();

        ResultPrinter.printLongResult(FILE_NAME,
                inputLines -> counter.getFactorCountForSingleRace(parser.parseSingleRecord(inputLines)));
    }
}
