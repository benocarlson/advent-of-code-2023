package day5seeds.part1;

public class LocationMinimizer {

    public long getLowestLocationForSeeds(SeedMapping mapping) {
        return mapping.seeds().stream()
                .map(seed -> mapping.seedToSoil().get(seed))
                .map(soil -> mapping.soilToFertilizer().get(soil))
                .map(fert -> mapping.fertilizerToWater().get(fert))
                .map(water -> mapping.waterToLight().get(water))
                .map(light -> mapping.lightToTemperature().get(light))
                .map(temp -> mapping.temperatureToHumidity().get(temp))
                .map(humid -> mapping.humidityToLocation().get(humid))
                .min(Long::compareTo)
                .orElseThrow();
    }
}
