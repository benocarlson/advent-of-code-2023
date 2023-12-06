package day6waitforit.part1;

import day6waitforit.RaceRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FactorCounterTest {

    private static final List<RaceRecord> testRaces = List.of(
            new RaceRecord(7, 9),
            new RaceRecord(15, 40),
            new RaceRecord(30, 200)
    );

    @Test
    public void factorCounterGetsCorrectFactorCount() {
        List<Integer> result = new FactorCounter().countFactorsForRaces(testRaces);
        assertThat(result).containsExactly(
                4, 8, 9
        );
    }

    @Test
    public void countMultiplierCorrectlyReduces() {
        Integer result = new FactorCounter().multiplyFactorsForRaces(testRaces);
        assertThat(result).isEqualTo(288);
    }

    @Test
    public void factorCountForSingleRaceIsCorrect() {
        Integer result = new FactorCounter().getFactorCountForSingleRace(
                new RaceRecord(71530, 940200)
        );
        assertThat(result).isEqualTo(71503);
    }

}