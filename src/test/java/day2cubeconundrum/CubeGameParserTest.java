package day2cubeconundrum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CubeGameParserTest {

    public static Stream<Arguments> cubeGameSource() {
        return Stream.of(
                Arguments.of(
                        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                        new CubeGame(1, List.of(
                                new CubeGame.Draw(4, 0, 3),
                                new CubeGame.Draw(1, 2, 6),
                                new CubeGame.Draw(0, 2, 0)
                        ))
                ),
                Arguments.of(
                        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                        new CubeGame(2, List.of(
                                new CubeGame.Draw(0, 2, 1),
                                new CubeGame.Draw(1, 3, 4),
                                new CubeGame.Draw(0, 1, 1)
                        ))
                ),
                Arguments.of(
                        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                        new CubeGame(3, List.of(
                                new CubeGame.Draw(20, 8, 6),
                                new CubeGame.Draw(4, 13, 5),
                                new CubeGame.Draw(1, 5, 0)
                        ))
                ),
                Arguments.of(
                        "Game 64: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                        new CubeGame(64, List.of(
                                new CubeGame.Draw(3, 1, 6),
                                new CubeGame.Draw(6, 3, 0),
                                new CubeGame.Draw(14, 3, 15)
                        ))
                ),
                Arguments.of(
                        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
                        new CubeGame(5, List.of(
                                new CubeGame.Draw(6, 3, 1),
                                new CubeGame.Draw(1, 2, 2)
                        ))
                )
        );
    }

    @ParameterizedTest
    @MethodSource(value = "cubeGameSource")
    public void cubeGameParserParsesCorrectly(String gameString, CubeGame expectedResult) {
        CubeGame result = CubeGameParser.parseStringAsCubeGame(gameString);
        assertThat(result).isEqualTo(expectedResult);
    }

}