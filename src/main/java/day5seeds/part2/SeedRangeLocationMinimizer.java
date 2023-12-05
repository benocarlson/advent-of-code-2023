package day5seeds.part2;

import java.util.List;

public class SeedRangeLocationMinimizer {

    public long getLowestLocationForSeeds(SeedRangeMapping mapping) {

        List<SeedRange> seedRanges = mapping.seeds();
        List<SeedRange> soilRanges = mapping.seedToSoil().getForRanges(seedRanges);
        List<SeedRange> fertilizerRanges = mapping.soilToFertilizer().getForRanges(soilRanges);
        List<SeedRange> waterRanges = mapping.fertilizerToWater().getForRanges(fertilizerRanges);
        List<SeedRange> lightRanges = mapping.waterToLight().getForRanges(waterRanges);
        List<SeedRange> temperatureRanges = mapping.lightToTemperature().getForRanges(lightRanges);
        List<SeedRange> humidityRanges = mapping.temperatureToHumidity().getForRanges(temperatureRanges);
        List<SeedRange> locationRanges = mapping.humidityToLocation().getForRanges(humidityRanges);

        return locationRanges.stream()
                .map(SeedRange::startSeed)
                .min(Long::compareTo)
                .orElseThrow();
    }
}
