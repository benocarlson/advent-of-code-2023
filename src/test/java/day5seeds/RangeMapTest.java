package day5seeds;

import day5seeds.part2.SeedRange;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class RangeMapTest {

    @Test
    public void rangeMapGetsCorrectMappings() {
        RangeMap rangeMap = new RangeMap(List.of(
                new RangeMap.MapRange(0L, 5L, 15L),
                new RangeMap.MapRange(15L, 0L, 5L),
                new RangeMap.MapRange(35L, 25L, 5L)
        ));

        assertThat(rangeMap.get(0L)).isEqualTo(15L);
        assertThat(rangeMap.get(1L)).isEqualTo(16L);
        assertThat(rangeMap.get(2L)).isEqualTo(17L);
        assertThat(rangeMap.get(3L)).isEqualTo(18L);
        assertThat(rangeMap.get(4L)).isEqualTo(19L);
        assertThat(rangeMap.get(5L)).isEqualTo(0L);
        assertThat(rangeMap.get(6L)).isEqualTo(1L);
        assertThat(rangeMap.get(7L)).isEqualTo(2L);
        assertThat(rangeMap.get(8L)).isEqualTo(3L);
        assertThat(rangeMap.get(9L)).isEqualTo(4L);
        assertThat(rangeMap.get(10L)).isEqualTo(5L);
        assertThat(rangeMap.get(11L)).isEqualTo(6L);
        assertThat(rangeMap.get(12L)).isEqualTo(7L);
        assertThat(rangeMap.get(13L)).isEqualTo(8L);
        assertThat(rangeMap.get(14L)).isEqualTo(9L);
        assertThat(rangeMap.get(15L)).isEqualTo(10L);
        assertThat(rangeMap.get(16L)).isEqualTo(11L);
        assertThat(rangeMap.get(17L)).isEqualTo(12L);
        assertThat(rangeMap.get(18L)).isEqualTo(13L);
        assertThat(rangeMap.get(19L)).isEqualTo(14L);
        assertThat(rangeMap.get(20L)).isEqualTo(20L);
        assertThat(rangeMap.get(21L)).isEqualTo(21L);
        assertThat(rangeMap.get(22L)).isEqualTo(22L);
        assertThat(rangeMap.get(23L)).isEqualTo(23L);
        assertThat(rangeMap.get(24L)).isEqualTo(24L);
        assertThat(rangeMap.get(25L)).isEqualTo(35L);
        assertThat(rangeMap.get(26L)).isEqualTo(36L);
        assertThat(rangeMap.get(27L)).isEqualTo(37L);
        assertThat(rangeMap.get(28L)).isEqualTo(38L);
        assertThat(rangeMap.get(29L)).isEqualTo(39L);
        assertThat(rangeMap.get(30L)).isEqualTo(30L);
        assertThat(rangeMap.get(31L)).isEqualTo(31L);
    }

    public static Stream<Arguments> mapRangeSource() {
        RangeMap.MapRange defaultMapRange = new RangeMap.MapRange(20L, 10L, 10L);
        return Stream.of(
                Arguments.of(
                        defaultMapRange,
                        new SeedRange(15, 10),
                        new SeedRange(25, 5),
                        List.of(new SeedRange(20, 5))
                ),
                Arguments.of(
                        defaultMapRange,
                        new SeedRange(10, 10),
                        new SeedRange(20, 10),
                        emptyList()
                ),
                Arguments.of(
                        defaultMapRange,
                        new SeedRange(13, 5),
                        new SeedRange(23, 5),
                        emptyList()
                ),
                Arguments.of(
                        defaultMapRange,
                        new SeedRange(5, 10),
                        new SeedRange(20, 5),
                        List.of(new SeedRange(5, 5))
                ),
                Arguments.of(
                        defaultMapRange,
                        new SeedRange(0, 5),
                        null,
                        List.of(new SeedRange(0, 5))
                ),
                Arguments.of(
                        defaultMapRange,
                        new SeedRange(5, 20),
                        new SeedRange(20, 10),
                        List.of(new SeedRange(5, 5),
                                new SeedRange(20, 5))
                ),
                Arguments.of(
                        defaultMapRange,
                        new SeedRange(25, 10),
                        null,
                        List.of(new SeedRange(25, 10))
                )
        );
    }



    @ParameterizedTest
    @MethodSource("mapRangeSource")
    public void mapRangeGetsForRange(RangeMap.MapRange mapRange, SeedRange keyRange, SeedRange expectedResult, List<SeedRange> expectedUnclaimed) {
        RangeMap.MapRange.RangeClaim resultRange = mapRange.getForRange(keyRange);

        assertThat(resultRange.valueRange()).isEqualTo(expectedResult);
        assertThat(resultRange.unclaimedRanges()).isEqualTo(expectedUnclaimed);
    }

}