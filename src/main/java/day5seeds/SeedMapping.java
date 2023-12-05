package day5seeds;

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
