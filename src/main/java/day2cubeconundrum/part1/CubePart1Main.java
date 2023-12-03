package day2cubeconundrum.part1;

import day2cubeconundrum.CubeGame;
import day2cubeconundrum.CubeGameParser;
import utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class CubePart1Main {
    private static final String DEFAULT_FILE_NAME = "inputFiles/day2cubeconundrum";
    public static void main(String[] args) {

        CubeGameValidator validator = new CubeGameValidator();

        try {
            List<CubeGame> cubeGames = FileUtils.getLinesFromFile(DEFAULT_FILE_NAME).stream()
                    .map(CubeGameParser::parseStringAsCubeGame).toList();
            int result = validator.sumValidGameIds(cubeGames);
            System.out.println("Result: " + result);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + DEFAULT_FILE_NAME);
        }
    }
}
