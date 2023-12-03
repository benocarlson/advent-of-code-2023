package day2cubeconundrum.part1;

import day2cubeconundrum.CubeGame;

import java.util.List;
import java.util.Optional;

public class CubeGameValidator {
    private static final int MAX_RED_COUNT = 12;
    private static final int MAX_GREEN_COUNT = 13;
    private static final int MAX_BLUE_COUNT = 14;

    public int sumValidGameIds(List<CubeGame> games) {
        return games.stream()
                .filter(this::isGameValid)
                .mapToInt(CubeGame::gameId)
                .sum();
    }

    boolean isGameValid(CubeGame cubeGame) {
        Optional<CubeGame.Draw> invalidDraw =
                cubeGame.draws().stream()
                        .filter(draw -> draw.blueCount() > MAX_BLUE_COUNT ||
                                draw.greenCount() > MAX_GREEN_COUNT ||
                                draw.redCount() > MAX_RED_COUNT)
                        .findFirst();

        return invalidDraw.isEmpty();
    }
}
