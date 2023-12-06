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
                new RaceRecord(7, 9),
                new RaceRecord(15, 40),
                new RaceRecord(30, 200)
        );
    }

    @Test
    public void raceParserParsesSingleRace() {
        RaceRecord result = new RaceParser().parseSingleRecord(testLines);
        assertThat(result).isEqualTo(new RaceRecord(71530, 940200));
    }

}