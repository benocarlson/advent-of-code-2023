package day2cubeconundrum.part2;

import day2cubeconundrum.CubeGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CubeGamePowerCalculatorTest {

    public static Stream<Arguments> cubeGameSource() {
        return Stream.of(
                Arguments.of(
                        new CubeGame(1, List.of(
                                new CubeGame.Draw(4, 0, 3),
                                new CubeGame.Draw(1, 2, 6),
                                new CubeGame.Draw(0, 2, 0)
                        )),
                        48
                ),
                Arguments.of(
                        new CubeGame(2, List.of(
                                new CubeGame.Draw(0, 2, 1),
                                new CubeGame.Draw(1, 3, 4),
                                new CubeGame.Draw(0, 1, 1)
                        )),
                        12
                ),
                Arguments.of(
                        new CubeGame(3, List.of(
                                new CubeGame.Draw(20, 8, 6),
                                new CubeGame.Draw(4, 13, 5),
                                new CubeGame.Draw(1, 5, 0)
                        )),
                        1560
                ),
                Arguments.of(
                        new CubeGame(4, List.of(
                                new CubeGame.Draw(3, 1, 6),
                                new CubeGame.Draw(6, 3, 0),
                                new CubeGame.Draw(14, 3, 15)
                        )),
                        630
                ),
                Arguments.of(
                        new CubeGame(5, List.of(
                                new CubeGame.Draw(6, 3, 1),
                                new CubeGame.Draw(1, 2, 2)
                        )),
                        36
                )
        );
    }

    @ParameterizedTest
    @MethodSource(value = "cubeGameSource")
    public void powerCalculatorCalculatesPowerCorrectly(CubeGame cubeGame, int expectedResult) {
        int result = new CubeGamePowerCalculator().calculateGamePower(cubeGame);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void powerCalculatorSumsGamePowersCorrectly() {
        List<CubeGame> testList = List.of(
                new CubeGame(1, List.of(
                        new CubeGame.Draw(4, 0, 3),
                        new CubeGame.Draw(1, 2, 6),
                        new CubeGame.Draw(0, 2, 0)
                )),
                new CubeGame(2, List.of(
                        new CubeGame.Draw(0, 2, 1),
                        new CubeGame.Draw(1, 3, 4),
                        new CubeGame.Draw(0, 1, 1)
                )),
                new CubeGame(3, List.of(
                        new CubeGame.Draw(20, 8, 6),
                        new CubeGame.Draw(4, 13, 5),
                        new CubeGame.Draw(1, 5, 0)
                )),
                new CubeGame(4, List.of(
                        new CubeGame.Draw(3, 1, 6),
                        new CubeGame.Draw(6, 3, 0),
                        new CubeGame.Draw(14, 3, 15)
                )),
                new CubeGame(5, List.of(
                        new CubeGame.Draw(6, 3, 1),
                        new CubeGame.Draw(1, 2, 2)
                ))
        );

        int result = new CubeGamePowerCalculator().sumGamePowers(testList);

        assertThat(result).isEqualTo(2286);
    }
}