package day2cubeconundrum.part1;

import day2cubeconundrum.CubeGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CubeGameValidatorTest {

    public static Stream<Arguments> cubeGameSource() {
        return Stream.of(
                Arguments.of(
                        new CubeGame(1, List.of(
                                new CubeGame.Draw(4, 0, 3),
                                new CubeGame.Draw(1, 2, 6),
                                new CubeGame.Draw(0, 2, 0)
                        )),
                        true
                ),
                Arguments.of(
                        new CubeGame(2, List.of(
                                new CubeGame.Draw(0, 2, 1),
                                new CubeGame.Draw(1, 3, 4),
                                new CubeGame.Draw(0, 1, 1)
                        )),
                        true
                ),
                Arguments.of(
                        new CubeGame(3, List.of(
                                new CubeGame.Draw(20, 8, 6),
                                new CubeGame.Draw(4, 13, 5),
                                new CubeGame.Draw(1, 5, 0)
                        )),
                        false
                ),
                Arguments.of(
                        new CubeGame(4, List.of(
                                new CubeGame.Draw(3, 1, 6),
                                new CubeGame.Draw(6, 3, 0),
                                new CubeGame.Draw(14, 3, 15)
                        )),
                        false
                ),
                Arguments.of(
                        new CubeGame(5, List.of(
                                new CubeGame.Draw(6, 3, 1),
                                new CubeGame.Draw(1, 2, 2)
                        )),
                        true
                ),
                Arguments.of(
                        new CubeGame(6, List.of(
                                new CubeGame.Draw(12, 1, 1)
                        )),
                        true
                ),
                Arguments.of(
                        new CubeGame(7, List.of(
                                new CubeGame.Draw(13, 1, 1)
                        )),
                        false
                ),
                Arguments.of(
                        new CubeGame(8, List.of(
                                new CubeGame.Draw(1, 13, 1)
                        )),
                        true
                ),
                Arguments.of(
                        new CubeGame(9, List.of(
                                new CubeGame.Draw(1, 14, 1)
                        )),
                        false
                ),
                Arguments.of(
                        new CubeGame(10, List.of(
                                new CubeGame.Draw(1, 1, 14)
                        )),
                        true
                ),
                Arguments.of(
                        new CubeGame(11, List.of(
                                new CubeGame.Draw(1, 1, 15)
                        )),
                        false
                )
        );
    }


    @ParameterizedTest
    @MethodSource(value = "cubeGameSource")
    public void cubeGameValidatorValidatesCubeGames(CubeGame cubeGame, boolean expectedResult) {
        boolean result = new CubeGameValidator().isGameValid(cubeGame);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void cubeGameValidatorSumsCorrectly() {
        List<CubeGame> testList = List.of(
                new CubeGame(1, List.of(new CubeGame.Draw(1, 1, 14))),
                new CubeGame(2, List.of(new CubeGame.Draw(1, 1, 15))),
                new CubeGame(4, List.of(new CubeGame.Draw(1, 1, 14))),
                new CubeGame(8, List.of(new CubeGame.Draw(1, 1, 15))),
                new CubeGame(16, List.of(new CubeGame.Draw(1, 1, 14))));

        int result = new CubeGameValidator().sumValidGameIds(testList);

        assertThat(result).isEqualTo(21);
    }
}