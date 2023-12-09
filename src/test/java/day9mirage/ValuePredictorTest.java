package day9mirage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValuePredictorTest {

    public static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(0L, 3L, 6L, 9L, 12L, 15L),
                        18L,
                        -3L
                ),
                Arguments.of(
                        List.of(1L, 3L, 6L, 10L, 15L, 21L),
                        28L,
                        0L
                ),
                Arguments.of(
                        List.of(10L, 13L, 16L, 21L, 30L, 45L),
                        68L,
                        5L
                )
        );
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    public void valuePredictorPredictsNextValue(List<Long> values, Long expectedNextPrediction, Long expectedPreviousPrediction) {
        long nextPrediction = new ValuePredictor().predictNextValue(values);
        assertThat(nextPrediction).isEqualTo(expectedNextPrediction);

        long previousPrediction = new ValuePredictor().predictPreviousValue(values);
        assertThat(previousPrediction).isEqualTo(expectedPreviousPrediction);
    }



}