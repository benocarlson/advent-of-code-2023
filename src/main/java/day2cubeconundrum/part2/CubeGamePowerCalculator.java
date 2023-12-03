package day2cubeconundrum.part2;

import day2cubeconundrum.CubeGame;

import java.util.List;

public class CubeGamePowerCalculator {

    public int sumGamePowers(List<CubeGame> cubeGames) {
        return cubeGames.stream()
                .mapToInt(this::calculateGamePower)
                .sum();
    }

    int calculateGamePower(CubeGame cubeGame) {
        int highestRed = 0;
        int highestGreen = 0;
        int highestBlue = 0;

        for (CubeGame.Draw draw : cubeGame.draws()) {
            if (highestRed < draw.redCount()) {
                highestRed = draw.redCount();
            }
            if (highestGreen < draw.greenCount()) {
                highestGreen = draw.greenCount();
            }
            if (highestBlue < draw.blueCount()) {
                highestBlue = draw.blueCount();
            }
        }
        return highestRed * highestGreen * highestBlue;
    }
}
