package day5seeds.part1;

import day5seeds.SeedMapParser;
import day5seeds.SeedMapping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LocationMinimizerTest {

    private final List<String> testLines = List.of(
            "seeds: 79 14 55 13",
            "",
            "seed-to-soil map:",
            "50 98 2",
            "52 50 48",
            "",
            "soil-to-fertilizer map:",
            "0 15 37",
            "37 52 2",
            "39 0 15",
            "",
            "fertilizer-to-water map:",
            "49 53 8",
            "0 11 42",
            "42 0 7",
            "57 7 4",
            "",
            "water-to-light map:",
            "88 18 7",
            "18 25 70",
            "",
            "light-to-temperature map:",
            "45 77 23",
            "81 45 19",
            "68 64 13",
            "",
            "temperature-to-humidity map:",
            "0 69 1",
            "1 0 69",
            "",
            "humidity-to-location map:",
            "60 56 37",
            "56 93 4"
    );

    private SeedMapping mapping;

    @BeforeEach
    public void setup() {
        SeedMapParser parser = new SeedMapParser();
        mapping = parser.parseSeedMapping(testLines); // I know, I know, it's supposed to be a unit test, but I really don't want to do this by hand
    }

    @Test
    public void locationMinimizerGetsCorrectLocation() {
        long result = new LocationMinimizer().getLowestLocationForSeeds(mapping);

        assertThat(result).isEqualTo(35);
    }
}