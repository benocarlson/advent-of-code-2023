package day5seeds.part2;

import day5seeds.RangeMap;

import java.util.List;

public record SeedRangeMapping(
        List<SeedRange> seeds,
        RangeMap seedToSoil,
        RangeMap soilToFertilizer,
        RangeMap fertilizerToWater,
        RangeMap waterToLight,
        RangeMap lightToTemperature,
        RangeMap temperatureToHumidity,
        RangeMap humidityToLocation) {
}

