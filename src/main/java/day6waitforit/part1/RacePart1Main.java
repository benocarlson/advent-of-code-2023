package day6waitforit.part1;

import day6waitforit.RaceParser;
import utils.ResultPrinter;

public class RacePart1Main {
    private static final String FILE_NAME = "inputFiles/day6waitforit";
    public static void main(String[] args) {
        FactorCounter counter = new FactorCounter();
        RaceParser parser = new RaceParser();

        ResultPrinter.printResult(FILE_NAME,
                inputLines -> counter.multiplyFactorsForRaces(parser.parseRaceRecords(inputLines)));
    }
}
