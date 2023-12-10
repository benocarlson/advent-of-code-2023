package day10pipemaze.part1;

import day10pipemaze.Pipe;

import java.util.Arrays;

public class MazeRunner {
    public int findDistanceToFarthestPointFromStart(Pipe[][] pipeMaze) {
        int currentY = findStartY(pipeMaze);
        int currentX = findStartX(pipeMaze[currentY]);

        Pipe.Direction nextDir = findStartDirection(pipeMaze, currentX, currentY);

        int stepCount = 0;
        do {
            stepCount++;
            switch (nextDir) {
                case EAST -> currentX++;
                case WEST -> currentX--;
                case NORTH -> currentY--;
                case SOUTH -> currentY++;
            }
            Pipe.Direction reverseDir = Pipe.Direction.reverse(nextDir);
            nextDir = pipeMaze[currentY][currentX].directionList.stream()
                    .filter(dir -> !dir.equals(reverseDir))
                    .findFirst()
                    .orElseThrow();
        } while (!pipeMaze[currentY][currentX].equals(Pipe.START));

        return stepCount / 2;
    }

    private Pipe.Direction findStartDirection(Pipe[][] pipeMaze, int startX, int startY) {
        if (startX > 0) {
            Pipe westOfStart = pipeMaze[startY][startX - 1];
            if (westOfStart.directionList.contains(Pipe.Direction.EAST)) {
                return Pipe.Direction.WEST;
            }
        }
        if (startY > 0) {
            Pipe northOfStart = pipeMaze[startY - 1][startX];
            if (northOfStart.directionList.contains(Pipe.Direction.SOUTH)) {
                return Pipe.Direction.NORTH;
            }
        }
        return Pipe.Direction.EAST; // we can shortcut here based on the assumption that at least two of the directions will work
    }

    private int findStartX(Pipe[] startRow) {
        for (int i = 0; i < startRow.length; i++) {
            if (startRow[i].equals(Pipe.START)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Could not find START position!");
    }

    private int findStartY(Pipe[][] pipeMaze) {
        for (int i = 0; i < pipeMaze.length; i++) {
            if (Arrays.asList(pipeMaze[i]).contains(Pipe.START)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Could not find START position!");
    }
}
