package day6waitforit.part1;

import day6waitforit.RaceRecord;

import java.util.ArrayList;
import java.util.List;

public class FactorCounter {
    public List<Integer> countFactorsForRaces(List<RaceRecord> races) {
        List<Integer> factorCounts = new ArrayList<>();
        for (RaceRecord race : races) {
            int victoryCount = 0;
            for (int i = 0; i <= race.time(); i++) {
                if (i * (race.time() - i) > race.recordDistance()) {
                    victoryCount++;
                }
            }
            factorCounts.add(victoryCount);
        }
        return factorCounts;
    }
}
