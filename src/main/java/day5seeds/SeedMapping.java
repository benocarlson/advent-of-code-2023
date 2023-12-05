package day5seeds;

import java.util.List;
import java.util.Map;

public record SeedMapping(List<Long> seeds,
                          Map<Long, Long> seedToSoil,
                          Map<Long, Long> soilToFertilizer,
                          Map<Long, Long> fertilizerToWater,
                          Map<Long, Long> waterToLight,
                          Map<Long, Long> lightToTemperature,
                          Map<Long, Long> temperatureToHumidity,
                          Map<Long, Long> humidityToLocation) {
}
