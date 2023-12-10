package day10pipemaze.part2;

import day10pipemaze.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class MazeDefiner {
    public Boolean[][] defineMaze(Pipe[][] pipeMaze) {
        Boolean[][] isPartOfMaze = new Boolean[pipeMaze.length][pipeMaze[0].length];
        int currentY = findStartY(pipeMaze);
        int currentX = findStartX(pipeMaze[currentY]);

        Pipe.Direction nextDir = findStartDirection(pipeMaze, currentX, currentY);

        do {
            switch (nextDir) {
                case EAST -> currentX++;
                case WEST -> currentX--;
                case NORTH -> currentY--;
                case SOUTH -> currentY++;
            }
            isPartOfMaze[currentY][currentX] = true;
            Pipe.Direction reverseDir = Pipe.Direction.reverse(nextDir);
            nextDir = pipeMaze[currentY][currentX].directionList.stream()
                    .filter(dir -> !dir.equals(reverseDir))
                    .findFirst()
                    .orElseThrow();
        } while (!pipeMaze[currentY][currentX].equals(Pipe.START));

        replaceStartWithPipe(pipeMaze, currentX, currentY);
        return isPartOfMaze;
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

    private void replaceStartWithPipe(Pipe[][] pipeMaze, int startX, int startY) {
        List<Pipe.Direction> dirs = new ArrayList<>();
        if (startX > 0) {
            Pipe westOfStart = pipeMaze[startY][startX - 1];
            if (westOfStart.directionList.contains(Pipe.Direction.EAST)) {
                dirs.add(Pipe.Direction.WEST);
            }
        }
        if (startY > 0) {
            Pipe northOfStart = pipeMaze[startY - 1][startX];
            if (northOfStart.directionList.contains(Pipe.Direction.SOUTH)) {
                dirs.add(Pipe.Direction.NORTH);
            }
        }
        if (startX < pipeMaze[0].length - 1) {
            Pipe eastOfStart = pipeMaze[startY][startX + 1];
            if (eastOfStart.directionList.contains(Pipe.Direction.WEST)) {
                dirs.add(Pipe.Direction.EAST);
            }
        }
        if (startY < pipeMaze.length - 1) {
            Pipe southOfStart = pipeMaze[startY + 1][startX];
            if (southOfStart.directionList.contains(Pipe.Direction.NORTH)) {
                dirs.add(Pipe.Direction.SOUTH);
            }
        }

        if (dirs.contains(Pipe.Direction.WEST)) {
            if (dirs.contains(Pipe.Direction.EAST)) {
                pipeMaze[startY][startX] = Pipe.EAST_WEST;
            }
            else if (dirs.contains(Pipe.Direction.NORTH)) {
                pipeMaze[startY][startX] = Pipe.NORTH_WEST;
            }
            else if (dirs.contains(Pipe.Direction.SOUTH)) {
                pipeMaze[startY][startX] = Pipe.SOUTH_WEST;
            }
        }
        else if (dirs.contains(Pipe.Direction.NORTH)) {
            if (dirs.contains(Pipe.Direction.SOUTH)) {
                pipeMaze[startY][startX] = Pipe.NORTH_SOUTH;
            }
            else if (dirs.contains(Pipe.Direction.EAST)) {
                pipeMaze[startY][startX] = Pipe.NORTH_EAST;
            }
        }
        else {
            pipeMaze[startY][startX] = Pipe.SOUTH_EAST;
        }
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

    public int countInsideTiles(Pipe[][] pipeMaze) {
        Boolean[][] mazeDefinition = defineMaze(pipeMaze);

        int insideTotal = 0;
        for (int y = 0; y < pipeMaze.length; y++) {
            boolean inside = false;
            for (int x = 0; x < pipeMaze[y].length; x++) {
                if (TRUE.equals(mazeDefinition[y][x])) {
                    if (pipeMaze[y][x].directionList.contains(Pipe.Direction.NORTH)) {
                        inside = !inside;
                    }
                }
                else if (inside) {
                    insideTotal++;
                }
            }
        }
        return insideTotal;
    }
}
