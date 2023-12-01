package day1trebuchet;

import day1trebuchet.part1.DigitFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DigitFinderTest {

    private DigitFinder digitFinder;

    @BeforeEach
    public void setup() {
        digitFinder = new DigitFinder();
    }

    @ParameterizedTest
    @CsvSource({
            "1abc2,                     12",
            "pqr3stu8vwx,               38",
            "a1b2c3d4e5f,               15",
            "treb7uchet,                77",
            "19,                        19",
            "0,                         0",
            "9,                         99",
            "172738465,                 15"
    })
    public void testGetValueForString(String inputString, int expectedValue) {
        int calculatedValue = digitFinder.getValueForString(inputString);
        assertThat(calculatedValue).isEqualTo(expectedValue);
    }
}