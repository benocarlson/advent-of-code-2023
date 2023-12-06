package day6waitforit;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceParserTest {

    private static final List<String> testLines = List.of(
            "Time:      7  15   30",
            "Distance:  9  40  200"
    );

    @Test
    public void raceParserParsesRaces() {
        List<RaceRecord> result = new RaceParser().parseRaceRecords(testLines);
        assertThat(result).containsExactly(
                new RaceRecord(7L, 9L),
                new RaceRecord(15L, 40L),
                new RaceRecord(30L, 200L)
        );
    }

    @Test
    public void raceParserParsesSingleRace() {
        RaceRecord result = new RaceParser().parseSingleRecord(testLines);
        assertThat(result).isEqualTo(new RaceRecord(71530L, 940200L));
    }

}