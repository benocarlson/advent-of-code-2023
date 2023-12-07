package day7camelcards.part1;

import day7camelcards.Hand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningsCalculatorTest {

    List<Hand> testList = List.of(
            new Hand("32T3K", 765, false),
            new Hand("T55J5", 684, false),
            new Hand("KK677", 28, false),
            new Hand("KTJJT", 220, false),
            new Hand("QQQJA", 483, false)
    );

    @Test
    public void winningsAreCalculatedCorrectly() {
        long result = new WinningsCalculator().calculateWinnings(testList);
        assertThat(result).isEqualTo(6440);
    }
}