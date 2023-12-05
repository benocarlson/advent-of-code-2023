package day5seeds.part1;

import day5seeds.RangeMap;
import day5seeds.SeedMapping;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LocationMinimizerTest {

    private final SeedMapping testMapping = new SeedMapping(
            List.of(79L, 14L, 55L, 13L),
            new RangeMap(List.of(
                    new RangeMap.MapRange(50L, 98L, 2L),
                    new RangeMap.MapRange(52L, 50L, 48L)
            )),
            new RangeMap(List.of(
                    new RangeMap.MapRange(0L, 15L, 37L),
                    new RangeMap.MapRange(37L, 52L, 2L),
                    new RangeMap.MapRange(39L, 0L, 15L)
            )),
            new RangeMap(List.of(
                    new RangeMap.MapRange(49L, 53L, 8L),
                    new RangeMap.MapRange(0L, 11L, 42L),
                    new RangeMap.MapRange(42L, 0L, 7L),
                    new RangeMap.MapRange(57L, 7L, 4L)
            )),
            new RangeMap(List.of(
                    new RangeMap.MapRange(88L, 18L, 7L),
                    new RangeMap.MapRange(18L, 25L, 70L)
            )),
            new RangeMap(List.of(
                    new RangeMap.MapRange(45L, 77L, 23L),
                    new RangeMap.MapRange(81L, 45L, 19L),
                    new RangeMap.MapRange(68L, 64L, 13L)
            )),
            new RangeMap(List.of(
                    new RangeMap.MapRange(0L, 69L, 1L),
                    new RangeMap.MapRange(1L, 0L, 69L)
            )),
            new RangeMap(List.of(
                    new RangeMap.MapRange(60L, 56L, 37L),
                    new RangeMap.MapRange(56L, 93L, 4L)
            ))
    );


    @Test
    public void locationMinimizerGetsCorrectLocation() {
        long result = new LocationMinimizer().getLowestLocationForSeeds(testMapping);

        assertThat(result).isEqualTo(35);
    }
}