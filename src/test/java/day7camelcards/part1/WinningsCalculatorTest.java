package day7camelcards.part1;

import day7camelcards.Hand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningsCalculatorTest {

    List<Hand> testList = List.of(
            new Hand("32T3K", 765),
            new Hand("T55J5", 684),
            new Hand("KK677", 28),
            new Hand("KTJJT", 220),
            new Hand("QQQJA", 483)
    );

    @Test
    public void winningsAreCalculatedCorrectly() {
        int result = new WinningsCalculator().calculateWinnings(testList);
        assertThat(result).isEqualTo(6440);
    }
}