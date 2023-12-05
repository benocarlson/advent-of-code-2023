package day5seeds;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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

    private SeedMapping mapping;

    @BeforeEach
    public void setup() {
        mapping = new SeedMapParser().parseSeedMapping(testLines);
        assertThat(mapping).isNotNull();
    }

    @Test
    public void parserParsesListOfSeeds() {
        assertThat(mapping.seeds())
                .containsExactly(79, 14, 55, 13);
    }

    @Test
    public void parserParsesSeedToSoilMap() {
        assertRange(50, 98, 2, mapping.seedToSoil(), "Seed to Soil Map Range 1");
        assertRange(52, 50, 48, mapping.seedToSoil(), "Seed to Soil Map Range 2");
    }

    @Test
    public void parserParsesSoilToFertilizerMap() {
        assertRange(0, 15, 37, mapping.soilToFertilizer(), "Soil to Fert Map Range 1");
        assertRange(37, 52, 2, mapping.soilToFertilizer(), "Soil to Fert Map Range 2");
        assertRange(39, 0, 15, mapping.soilToFertilizer(), "Soil to Fert Map Range 2");
    }

    @Test
    public void parserParsesFertilizerToWaterMap() {
        assertRange(49, 53, 8, mapping.fertilizerToWater(), "Fert to Water Map Range 1");
        assertRange(0, 11, 42, mapping.fertilizerToWater(), "Fert to Water Map Range 2");
        assertRange(42, 0, 7, mapping.fertilizerToWater(), "Fert to Water Map Range 3");
        assertRange(57, 7, 4, mapping.fertilizerToWater(), "Fert to Water Map Range 4");
    }

    @Test
    public void parserParsesWaterToLightMap() {
        assertRange(88, 18, 7, mapping.waterToLight(), "Water to Light Map Range 1");
        assertRange(18, 25, 4, mapping.waterToLight(), "Water to Light Map Range 2");
    }

    @Test
    public void parserParsesLightToTemperatureMap() {
        assertRange(45, 77, 23, mapping.lightToTemperature(), "Light to Temp Map Range 1");
        assertRange(81, 45, 19, mapping.lightToTemperature(), "Light to Temp Map Range 2");
        assertRange(68, 64, 13, mapping.lightToTemperature(), "Light to Temp Map Range 3");
    }

    @Test
    public void parserParsesTemperatureToHumidityMap() {
        assertRange(0, 69, 1, mapping.temperatureToHumidity(), "Temp to Humid Map Range 1");
        assertRange(1, 0, 69, mapping.temperatureToHumidity(), "Temp to Humid Map Range 2");
    }

    @Test
    public void parserParsesHumidityToLocationMap() {
        assertRange(60, 56, 37, mapping.humidityToLocation(), "Humid to Loc Map Range 1");
        assertRange(56, 93, 4, mapping.humidityToLocation(), "Humid to Loc Map Range 2");
    }

    private void assertRange(int valueStart, int keyStart, int rangeLength, Map<Integer, Integer> map, String logString) {
        System.out.println(logString);
        int i = valueStart;
        int j = keyStart;
        int k = 0;
        while (k < rangeLength) {
            assertThat(map)
                    .containsEntry(j, i);
            k++;
            i++;
            j++;
        }
    }
}