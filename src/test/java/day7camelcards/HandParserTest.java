package day7camelcards;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HandParserTest {

    private static final List<String> testLines = List.of(
            "32T3K 765",
            "T55J5 684",
            "KK677 28",
            "KTJJT 220",
            "QQQJA 483"
    );

    @Test
    public void handParserParsesHands() {
        List<Hand> hands = new HandParser().parseHands(testLines);

        assertThat(hands).containsExactly(
                new Hand("32T3K", 765, false),
                new Hand("T55J5", 684, false),
                new Hand("KK677", 28, false),
                new Hand("KTJJT", 220, false),
                new Hand("QQQJA", 483, false)
        );
    }

}