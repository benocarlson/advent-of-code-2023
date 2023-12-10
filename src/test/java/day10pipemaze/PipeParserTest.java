package day10pipemaze;

import org.junit.jupiter.api.Test;

import java.util.List;

import static day10pipemaze.Pipe.*;
import static org.assertj.core.api.Assertions.assertThat;

class PipeParserTest {

    private static List<String> testInputLines = List.of(
            "7-F7-",
            ".FJ|7",
            "SJLL7",
            "|F--J",
            "LJ.LJ"
    );

    private static Pipe[][] testPipeArray = new Pipe[][] {
            new Pipe[] { SOUTH_WEST, EAST_WEST, SOUTH_EAST, SOUTH_WEST, EAST_WEST },
            new Pipe[] { NONE, SOUTH_EAST, NORTH_WEST, NORTH_SOUTH, SOUTH_WEST },
            new Pipe[] { START, NORTH_WEST, NORTH_EAST, NORTH_EAST, SOUTH_WEST },
            new Pipe[] { NORTH_SOUTH, SOUTH_EAST, EAST_WEST, EAST_WEST, NORTH_WEST },
            new Pipe[] { NORTH_EAST, NORTH_WEST, NONE, NORTH_EAST, NORTH_WEST }
    };

    @Test
    public void pipeMazeParserParsesPipeMaze() {
        Pipe[][] result = new PipeParser().parsePipeMaze(testInputLines);

        assertThat(result).isEqualTo(testPipeArray);
    }

}