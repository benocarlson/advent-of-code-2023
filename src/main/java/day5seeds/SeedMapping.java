package day5seeds;

import java.util.List;
import java.util.Map;

public record SeedMapping(List<Integer> seeds,
                          Map<Integer, Integer> seedToSoil,
                          Map<Integer, Integer> soilToFertilizer,
                          Map<Integer, Integer> fertilizerToWater,
                          Map<Integer, Integer> waterToLight,
                          Map<Integer, Integer> lightToTemperature,
                          Map<Integer, Integer> temperatureToHumidity,
                          Map<Integer, Integer> humidityToLocation) {
}
