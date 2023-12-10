package day10pipemaze;

import java.util.List;

public enum Pipe {
    NONE,
    START(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST),
    NORTH_WEST(Direction.NORTH, Direction.WEST),
    NORTH_EAST(Direction.NORTH, Direction.EAST),
    SOUTH_WEST(Direction.SOUTH, Direction.WEST),
    SOUTH_EAST(Direction.SOUTH, Direction.EAST),
    NORTH_SOUTH(Direction.NORTH, Direction.SOUTH),
    EAST_WEST(Direction.EAST, Direction.WEST);

    public final List<Direction> directionList;

    Pipe(Direction... directions) {
        directionList = List.of(directions);
    }

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        public static Direction reverse(Direction dir) {
            return switch (dir) {
                case SOUTH -> NORTH;
                case NORTH -> SOUTH;
                case WEST -> EAST;
                case EAST -> WEST;
            };
        }
    }

    public static Pipe forChar(char character) {
        return switch (character) {
            case '.' -> NONE;
            case '-' -> EAST_WEST;
            case '|' -> NORTH_SOUTH;
            case 'L' -> NORTH_EAST;
            case 'J' -> NORTH_WEST;
            case '7' -> SOUTH_WEST;
            case 'F' -> SOUTH_EAST;
            case 'S' -> START;
            default -> throw new IllegalArgumentException("Character not a valid pipe: " + character);
        };
    }
}
