package day10pipemaze.part1;

import day10pipemaze.Pipe;
import org.junit.jupiter.api.Test;

import static day10pipemaze.Pipe.*;
import static day10pipemaze.Pipe.NORTH_WEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MazeRunnerTest {

    private static final Pipe[][] testPipeArray = new Pipe[][] {
            new Pipe[] { SOUTH_WEST, EAST_WEST, SOUTH_EAST, SOUTH_WEST, EAST_WEST },
            new Pipe[] { NONE, SOUTH_EAST, NORTH_WEST, NORTH_SOUTH, SOUTH_WEST },
            new Pipe[] { START, NORTH_WEST, NORTH_EAST, NORTH_EAST, SOUTH_WEST },
            new Pipe[] { NORTH_SOUTH, SOUTH_EAST, EAST_WEST, EAST_WEST, NORTH_WEST },
            new Pipe[] { NORTH_EAST, NORTH_WEST, NONE, NORTH_EAST, NORTH_WEST }
    };

    @Test
    public void mazeRunnerReturnsCorrectStepsToDistantPoint() {
        int result = new MazeRunner().findDistanceToFarthestPointFromStart(testPipeArray);

        assertThat(result).isEqualTo(8);
    }

}