package day5seeds;

import java.util.*;

public class SeedMapParser {
    private static final String SEED_PREFIX = "seeds: ";
    private static final String SEED_TO_SOIL_INDICATOR = "seed-to-soil map:";
    private static final String SOIL_TO_FERTILIZER_INDICATOR = "soil-to-fertilizer map:";
    private static final String FERTILIZER_TO_WATER_INDICATOR = "fertilizer-to-water map:";
    private static final String WATER_TO_LIGHT_INDICATOR = "water-to-light map:";
    private static final String LIGHT_TO_TEMPERATURE_INDICATOR = "light-to-temperature map:";
    private static final String TEMPERATURE_TO_HUMIDITY_INDICATOR = "temperature-to-humidity map:";
    private static final String HUMIDITY_TO_LOCATION_INDICATOR = "humidity-to-location map:";


    public SeedMapping parseSeedMapping(List<String> inputLines) {

        return new SeedMapping(
                parseSeedList(inputLines.get(0)),
                parseMap(getRangeDefinitions(inputLines, SEED_TO_SOIL_INDICATOR)),
                parseMap(getRangeDefinitions(inputLines, SOIL_TO_FERTILIZER_INDICATOR)),
                parseMap(getRangeDefinitions(inputLines, FERTILIZER_TO_WATER_INDICATOR)),
                parseMap(getRangeDefinitions(inputLines, WATER_TO_LIGHT_INDICATOR)),
                parseMap(getRangeDefinitions(inputLines, LIGHT_TO_TEMPERATURE_INDICATOR)),
                parseMap(getRangeDefinitions(inputLines, TEMPERATURE_TO_HUMIDITY_INDICATOR)),
                parseMap(getRangeDefinitions(inputLines, HUMIDITY_TO_LOCATION_INDICATOR)));
    }

    private List<Long> parseSeedList(String seedLine) {
        return Arrays.stream(
                seedLine
                        .substring(SEED_PREFIX.length())
                        .strip()
                        .split("\\s+"))
                .map(Long::parseLong)
                .toList();
    }

    private RangeMap parseMap(List<String> rangeDefinitions) {
        List<RangeMap.MapRange> ranges = new ArrayList<>();
        for (String definition : rangeDefinitions) {
            String[] values = definition.strip().split("\\s+");
            long valueStart = Long.parseLong(values[0]);
            long keyStart = Long.parseLong(values[1]);
            long rangeLength = Long.parseLong(values[2]);
            ranges.add(new RangeMap.MapRange(valueStart, keyStart, rangeLength));
        }
        return new RangeMap(ranges);
    }

    private List<String> getRangeDefinitions(List<String> inputLines, String indicator) {
        List<String> rangeDefinitions = new ArrayList<>();

        int indicatorIndex = inputLines.indexOf(indicator);

        int definitionIndex = indicatorIndex + 1;
        String currentLine = inputLines.get(definitionIndex);

        while (!currentLine.isEmpty()) {
            rangeDefinitions.add(currentLine);

            definitionIndex++;
            if (definitionIndex < inputLines.size()) {
                currentLine = inputLines.get(definitionIndex);
            }
            else {
                currentLine = "";
            }
        }
        return rangeDefinitions;
    }
}
