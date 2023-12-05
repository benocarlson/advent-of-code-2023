package day5seeds;


import day5seeds.part1.SeedMapping;
import day5seeds.part2.SeedRange;
import day5seeds.part2.SeedRangeMapping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeedMapParserTest {

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

    private final SeedMapping expectedMapping = new SeedMapping(
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

    private final SeedRangeMapping expectedSeedRangeMapping = new SeedRangeMapping(
            List.of(new SeedRange(79L, 14L), new SeedRange(55L, 13L)),
                    expectedMapping.seedToSoil(),
                    expectedMapping.soilToFertilizer(),
                    expectedMapping.fertilizerToWater(),
                    expectedMapping.waterToLight(),
                    expectedMapping.lightToTemperature(),
                    expectedMapping.temperatureToHumidity(),
                    expectedMapping.humidityToLocation()
            );


    private SeedMapping mapping;

    @BeforeEach
    public void setup() {
        mapping = new SeedMapParser().parseSeedMapping(testLines);
        assertThat(mapping).isNotNull();
    }

    @Test
    public void parserParsesSeedMappingCorrectly() {
        assertThat(mapping).isEqualTo(expectedMapping);
    }

    @Test
    public void parserParsesSeedRangeMappingCorrectly() {
        SeedRangeMapping rangeMapping = new SeedMapParser().parseSeedRangeMapping(testLines);
        assertThat(rangeMapping).isEqualTo(expectedSeedRangeMapping);
    }

    @Test
    public void parserParsesListOfSeeds() {
        assertThat(mapping.seeds())
                .containsExactly(79L, 14L, 55L, 13L);
    }

    @Test
    public void parserParsesSeedToSoilMap() {
        assertRange(50L, 98L, 2L, mapping.seedToSoil(), "Seed to Soil Map Range 1");
        assertRange(52L, 50L, 48L, mapping.seedToSoil(), "Seed to Soil Map Range 2");
    }

    @Test
    public void parserParsesSoilToFertilizerMap() {
        assertRange(0L, 15L, 37L, mapping.soilToFertilizer(), "Soil to Fert Map Range 1");
        assertRange(37L, 52L, 2L, mapping.soilToFertilizer(), "Soil to Fert Map Range 2");
        assertRange(39L, 0L, 15L, mapping.soilToFertilizer(), "Soil to Fert Map Range 2");
    }

    @Test
    public void parserParsesFertilizerToWaterMap() {
        assertRange(49L, 53L, 8L, mapping.fertilizerToWater(), "Fert to Water Map Range 1");
        assertRange(0L, 11L, 42L, mapping.fertilizerToWater(), "Fert to Water Map Range 2");
        assertRange(42L, 0L, 7L, mapping.fertilizerToWater(), "Fert to Water Map Range 3");
        assertRange(57L, 7L, 4L, mapping.fertilizerToWater(), "Fert to Water Map Range 4");
    }

    @Test
    public void parserParsesWaterToLightMap() {
        assertRange(88L, 18L, 7L, mapping.waterToLight(), "Water to Light Map Range 1");
        assertRange(18L, 25L, 70L, mapping.waterToLight(), "Water to Light Map Range 2");
    }

    @Test
    public void parserParsesLightToTemperatureMap() {
        assertRange(45L, 77L, 23L, mapping.lightToTemperature(), "Light to Temp Map Range 1");
        assertRange(81L, 45L, 19L, mapping.lightToTemperature(), "Light to Temp Map Range 2");
        assertRange(68L, 64L, 13L, mapping.lightToTemperature(), "Light to Temp Map Range 3");
    }

    @Test
    public void parserParsesTemperatureToHumidityMap() {
        assertRange(0L, 69L, 1L, mapping.temperatureToHumidity(), "Temp to Humid Map Range 1");
        assertRange(1L, 0L, 69L, mapping.temperatureToHumidity(), "Temp to Humid Map Range 2");
    }

    @Test
    public void parserParsesHumidityToLocationMap() {
        assertRange(60L, 56L, 37L, mapping.humidityToLocation(), "Humid to Loc Map Range 1");
        assertRange(56L, 93L, 4L, mapping.humidityToLocation(), "Humid to Loc Map Range 2");
    }

    private void assertRange(long valueStart, long keyStart, long rangeLength, RangeMap map, String logString) {
        System.out.println(logString);
        long i = valueStart;
        long j = keyStart;
        long k = 0;
        while (k < rangeLength) {
            assertThat(map.get(j)).isEqualTo(i);
            k++;
            i++;
            j++;
        }
    }
}