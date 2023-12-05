package day5seeds.part2;

import day5seeds.SeedMapParser;
import utils.ResultPrinter;

public class SeedPart2Main {
    private static final String FILE_NAME = "inputFiles/day5seeds";
    public static void main(String[] args) {
        SeedMapParser parser = new SeedMapParser();
        SeedRangeLocationMinimizer minimizer = new SeedRangeLocationMinimizer();

        ResultPrinter.printLongResult(FILE_NAME, inputLines -> minimizer.getLowestLocationForSeeds(parser.parseSeedRangeMapping(inputLines)));
    }
}
