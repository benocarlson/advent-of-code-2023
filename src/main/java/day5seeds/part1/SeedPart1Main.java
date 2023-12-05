package day5seeds.part1;

import day5seeds.SeedMapParser;
import utils.ResultPrinter;

public class SeedPart1Main {

    private static final String FILE_NAME = "inputFiles/day5seeds";
    public static void main(String[] args) {
        SeedMapParser parser = new SeedMapParser();
        LocationMinimizer minimizer = new LocationMinimizer();

        ResultPrinter.printLongResult(FILE_NAME, inputLines -> minimizer.getLowestLocationForSeeds(parser.parseSeedMapping(inputLines)));
    }
}
