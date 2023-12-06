package day6waitforit;

import java.util.ArrayList;
import java.util.List;

public class RaceParser {

    private static final String TIME_PREFIX = "Time:";
    private static final String DISTANCE_PREFIX = "Distance:";
    public List<RaceRecord> parseRaceRecords(List<String> inputLines) {
        List<RaceRecord> raceRecords = new ArrayList<>();
        String[] times = inputLines.get(0).substring(TIME_PREFIX.length()).strip().split("\\s+");
        String[] distances = inputLines.get(1).substring(DISTANCE_PREFIX.length()).strip().split("\\s+");
        for (int i = 0; i < times.length; i++) {
            raceRecords.add(
                    new RaceRecord(Integer.parseInt(times[i]), Integer.parseInt(distances[i]))
            );
        }
        return raceRecords;
    }

    public RaceRecord parseSingleRecord(List<String> inputLines) {
        String distance = inputLines.get(1).substring(DISTANCE_PREFIX.length()).replaceAll("\\s", "");
        String time = inputLines.get(0).substring(TIME_PREFIX.length()).replaceAll("\\s", "");

        return new RaceRecord(Integer.parseInt(time), Integer.parseInt(distance));
    }
}
