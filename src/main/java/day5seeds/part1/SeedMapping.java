package day5seeds.part1;

import day5seeds.RangeMap;

import java.util.List;

public record SeedMapping(List<Long> seeds,
                          RangeMap seedToSoil,
                          RangeMap soilToFertilizer,
                          RangeMap fertilizerToWater,
                          RangeMap waterToLight,
                          RangeMap lightToTemperature,
                          RangeMap temperatureToHumidity,
                          RangeMap humidityToLocation) {

}
