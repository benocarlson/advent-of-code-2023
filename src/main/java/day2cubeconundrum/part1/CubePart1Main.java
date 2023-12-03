package day2cubeconundrum.part1;

import day2cubeconundrum.CubeGameParser;
import utils.ResultPrinter;

public class CubePart1Main {
    private static final String DEFAULT_FILE_NAME = "inputFiles/day2cubeconundrum";
    public static void main(String[] args) {

        CubeGameValidator validator = new CubeGameValidator();

        ResultPrinter.printResult(DEFAULT_FILE_NAME, inputLines -> validator.sumValidGameIds(
                inputLines.stream()
                        .map(CubeGameParser::parseStringAsCubeGame)
                        .toList()));
    }
}
