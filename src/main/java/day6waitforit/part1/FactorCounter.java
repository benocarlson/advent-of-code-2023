package day6waitforit.part1;

import day6waitforit.RaceRecord;

import java.util.ArrayList;
import java.util.List;

public class FactorCounter {
    public List<Long> countFactorsForRaces(List<RaceRecord> races) {
        List<Long> factorCounts = new ArrayList<>();
        for (RaceRecord race : races) {
            factorCounts.add(getFactorCountForSingleRace(race));
        }
        return factorCounts;
    }

    public Long multiplyFactorsForRaces(List<RaceRecord> races) {
        return countFactorsForRaces(races).stream()
                .mapToLong(val -> val)
                .reduce(1, (x, y) -> x * y);
    }

    public Long getFactorCountForSingleRace(RaceRecord race) {
        long victoryCount = 0;
        for (int i = 0; i <= race.time(); i++) {
            if (i * (race.time() - i) > race.recordDistance()) {
                victoryCount++;
            }
        }
        return victoryCount;
    }
}
