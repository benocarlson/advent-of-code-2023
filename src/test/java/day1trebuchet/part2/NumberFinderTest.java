package day1trebuchet.part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberFinderTest {

    private NumberFinder numberFinder;

    @BeforeEach
    public void setup() {
        numberFinder = new NumberFinder();
    }

    @ParameterizedTest
    @CsvSource({
            "two1nine,          29",
            "eightwothree,      83",
            "abcone2threexyz,   13",
            "xtwone3four,       24",
            "4nineeightseven2,  42",
            "zoneight234,       14",
            "7pqrstsixteen,     76",
            "dlrczxpfxp1,       11",
            "4asdfasdfasdf,     44"
    })
    public void testGetValueForString(String inputString, int expectedValue) {
        int calculatedValue = numberFinder.getValueForString(inputString);
        assertThat(calculatedValue).isEqualTo(expectedValue);
    }

}