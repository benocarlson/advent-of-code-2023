package day5seeds.part1;

import day5seeds.SeedMapping;

public class LocationMinimizer {

    public int getLowestLocationForSeeds(SeedMapping mapping) {
        return mapping.seeds().stream()
                .map(seed -> mapping.seedToSoil().getOrDefault(seed, seed))
                .map(soil -> mapping.soilToFertilizer().getOrDefault(soil, soil))
                .map(fert -> mapping.fertilizerToWater().getOrDefault(fert, fert))
                .map(water -> mapping.waterToLight().getOrDefault(water, water))
                .map(light -> mapping.lightToTemperature().getOrDefault(light, light))
                .map(temp -> mapping.temperatureToHumidity().getOrDefault(temp, temp))
                .map(humid -> mapping.humidityToLocation().getOrDefault(humid, humid))
                .min(Integer::compareTo)
                .orElseThrow();
    }
}
