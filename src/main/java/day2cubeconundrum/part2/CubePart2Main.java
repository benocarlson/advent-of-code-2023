package day2cubeconundrum.part2;

import day2cubeconundrum.CubeGameParser;
import utils.ResultPrinter;

public class CubePart2Main {
    private static final String DEFAULT_FILE_NAME = "inputFiles/day2cubeconundrum";
    public static void main(String[] args) {

        CubeGamePowerCalculator calculator = new CubeGamePowerCalculator();

        ResultPrinter.printResult(DEFAULT_FILE_NAME, inputLines -> calculator.sumGamePowers(
                inputLines.stream()
                        .map(CubeGameParser::parseStringAsCubeGame)
                        .toList()));
    }
}
