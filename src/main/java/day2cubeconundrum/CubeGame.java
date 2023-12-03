package day2cubeconundrum;

import java.util.List;

public record CubeGame(Integer gameId, List<Draw> draws) {
    public record Draw(Integer redCount, Integer greenCount, Integer blueCount){}
}
