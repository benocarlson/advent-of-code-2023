package day2cubeconundrum;

import java.util.Arrays;
import java.util.List;

public class CubeGameParser {

    private static final String GAME_ID_DELIMITER = ":";
    private static final String GAME_ID_PREFIX = "Game ";
    private static final String DRAW_DELIMITER = ";";
    private static final String SUB_DRAW_DELIMITER = ",";
    private static final String RED = "red";
    private static final String GREEN = "green";
    private static final String BLUE = "blue";
    public static CubeGame parseStringAsCubeGame(String gameString) {

        Integer gameId = Integer.parseInt(gameString.substring(GAME_ID_PREFIX.length(), gameString.indexOf(GAME_ID_DELIMITER)));

        List<CubeGame.Draw> draws = Arrays.stream(gameString
                .substring(gameString.indexOf(GAME_ID_DELIMITER) + 1)
                .strip()
                .split(DRAW_DELIMITER))
                .map(draw -> {
                    int redCount = 0;
                    int greenCount = 0;
                    int blueCount = 0;
                    String[] counts = draw.strip().split(SUB_DRAW_DELIMITER);
                    for (String count : counts) {
                        String[] countParts = count.strip().split("\\s");
                        switch (countParts[1]) {
                            case RED -> redCount = Integer.parseInt(countParts[0]);
                            case GREEN -> greenCount = Integer.parseInt(countParts[0]);
                            case BLUE -> blueCount = Integer.parseInt(countParts[0]);
                        }
                    }
                    return new CubeGame.Draw(redCount, greenCount, blueCount);
                }).toList();

        return new CubeGame(gameId, draws);
    }

}
