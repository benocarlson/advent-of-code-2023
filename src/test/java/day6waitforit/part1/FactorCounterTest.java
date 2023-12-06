package day6waitforit.part1;

import day6waitforit.RaceRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FactorCounterTest {

    private static final List<RaceRecord> testRaces = List.of(
            new RaceRecord(7L, 9L),
            new RaceRecord(15L, 40L),
            new RaceRecord(30L, 200L)
    );

    @Test
    public void factorCounterGetsCorrectFactorCount() {
        List<Long> result = new FactorCounter().countFactorsForRaces(testRaces);
        assertThat(result).containsExactly(
                4L, 8L, 9L
        );
    }

    @Test
    public void countMultiplierCorrectlyReduces() {
        Long result = new FactorCounter().multiplyFactorsForRaces(testRaces);
        assertThat(result).isEqualTo(288);
    }

    @Test
    public void factorCountForSingleRaceIsCorrect() {
        Long result = new FactorCounter().getFactorCountForSingleRace(
                new RaceRecord(71530L, 940200L)
        );
        assertThat(result).isEqualTo(71503);
    }

}