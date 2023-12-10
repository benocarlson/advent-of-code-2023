package day10pipemaze.part2;

import day10pipemaze.Pipe;
import org.junit.jupiter.api.Test;

import static day10pipemaze.Pipe.*;
import static org.assertj.core.api.Assertions.assertThat;

class MazeDefinerTest {



    private static final Pipe[][] expectedPipeArray = new Pipe[][] {
            new Pipe[] { SOUTH_WEST, EAST_WEST, SOUTH_EAST, SOUTH_WEST, EAST_WEST },
            new Pipe[] { NONE, SOUTH_EAST, NORTH_WEST, NORTH_SOUTH, SOUTH_WEST },
            new Pipe[] { SOUTH_EAST, NORTH_WEST, NORTH_EAST, NORTH_EAST, SOUTH_WEST },
            new Pipe[] { NORTH_SOUTH, SOUTH_EAST, EAST_WEST, EAST_WEST, NORTH_WEST },
            new Pipe[] { NORTH_EAST, NORTH_WEST, NONE, NORTH_EAST, NORTH_WEST }
    };

    private static final Boolean[][] expectedMazeDefinition = new Boolean[][] {
            new Boolean[] { null, null, true, true, null },
            new Boolean[] { null, true, true, true, null },
            new Boolean[] { true, true, null, true, true },
            new Boolean[] { true, true, true, true, true },
            new Boolean[] { true, true, null, null, null }
    };

    @Test
    public void mazeDefinerDefinesMazeAndReplacesStartWithPipe() {
        Pipe[][] testPipeArray = new Pipe[][] {
                new Pipe[] { SOUTH_WEST, EAST_WEST, SOUTH_EAST, SOUTH_WEST, EAST_WEST },
                new Pipe[] { NONE, SOUTH_EAST, NORTH_WEST, NORTH_SOUTH, SOUTH_WEST },
                new Pipe[] { START, NORTH_WEST, NORTH_EAST, NORTH_EAST, SOUTH_WEST },
                new Pipe[] { NORTH_SOUTH, SOUTH_EAST, EAST_WEST, EAST_WEST, NORTH_WEST },
                new Pipe[] { NORTH_EAST, NORTH_WEST, NONE, NORTH_EAST, NORTH_WEST }};

        Boolean[][] result = new MazeDefiner().defineMaze(testPipeArray);

        assertThat(result).isEqualTo(expectedMazeDefinition);
        assertThat(testPipeArray).isEqualTo(expectedPipeArray);
    }

    @Test
    public void mazeDefinerCountsInsideTiles() {
        Pipe[][] testPipeArray = new Pipe[][] {
                new Pipe[] { SOUTH_WEST, EAST_WEST, SOUTH_EAST, SOUTH_WEST, EAST_WEST },
                new Pipe[] { NONE, SOUTH_EAST, NORTH_WEST, NORTH_SOUTH, SOUTH_WEST },
                new Pipe[] { START, NORTH_WEST, NORTH_EAST, NORTH_EAST, SOUTH_WEST },
                new Pipe[] { NORTH_SOUTH, SOUTH_EAST, EAST_WEST, EAST_WEST, NORTH_WEST },
                new Pipe[] { NORTH_EAST, NORTH_WEST, NONE, NORTH_EAST, NORTH_WEST }};

        int result = new MazeDefiner().countInsideTiles(testPipeArray);

        assertThat(result).isEqualTo(1);
    }

}