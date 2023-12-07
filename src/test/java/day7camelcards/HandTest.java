package day7camelcards;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static day7camelcards.Hand.Card.*;
import static day7camelcards.Hand.HandType.*;
import static org.assertj.core.api.Assertions.assertThat;

class HandTest {

    public static Stream<Arguments> handSource() {
        return Stream.of(
                Arguments.of(
                        "2QTA6",
                        List.of(TWO, QUEEN, TEN, ACE, SIX),
                        HIGH_CARD
                ),
                Arguments.of(
                        "22222",
                        List.of(TWO, TWO, TWO, TWO, TWO),
                        FIVE_OF_A_KIND
                ),
                Arguments.of(
                        "7Q777",
                        List.of(SEVEN, QUEEN, SEVEN, SEVEN, SEVEN),
                        FOUR_OF_A_KIND
                ),
                Arguments.of(
                        "55335",
                        List.of(FIVE, FIVE, THREE, THREE, FIVE),
                        FULL_HOUSE
                ),
                Arguments.of(
                        "4A494",
                        List.of(FOUR, ACE, FOUR, NINE, FOUR),
                        THREE_OF_A_KIND
                ),
                Arguments.of(
                        "6J6J2",
                        List.of(SIX, JACK, SIX, JACK, TWO),
                        TWO_PAIR
                ),
                Arguments.of(
                        "7K8K9",
                        List.of(SEVEN, KING, EIGHT, KING, NINE),
                        ONE_PAIR
                )
        );
    }

    @ParameterizedTest
    @MethodSource("handSource")
    public void handConstructsWithString(String cardString, List<Hand.Card> expectedCardList, Hand.HandType expectedType) {
        Hand hand = new Hand(cardString, 10, false);

        assertThat(hand.getCards()).isEqualTo(expectedCardList);
        assertThat(hand.getHandType()).isEqualTo(expectedType);
    }

    @Test
    public void handsOrderCorrectly() {
        List<Hand> handList = new java.util.ArrayList<>(List.of(
                new Hand("AAAAA", 0, false),
                new Hand("AKQJT", 0, false),
                new Hand("AKKJT", 0, false),
                new Hand("ATTJT", 0, false),
                new Hand("ATAT6", 0, false),
                new Hand("33332", 0, false),
                new Hand("TT999", 0, false),
                new Hand("23456", 0, false),
                new Hand("TTT99", 0, false),
                new Hand("AKQJ9", 0, false),
                new Hand("ATT4T", 0, false),
                new Hand("A6AT6", 0, false)
        ));

        handList.sort(Hand::compareTo);
        assertThat(handList).containsExactly(
                new Hand("23456", 0, false),
                new Hand("AKQJ9", 0, false),
                new Hand("AKQJT", 0, false),
                new Hand("AKKJT", 0, false),
                new Hand("A6AT6", 0, false),
                new Hand("ATAT6", 0, false),
                new Hand("ATT4T", 0, false),
                new Hand("ATTJT", 0, false),
                new Hand("TT999", 0, false),
                new Hand("TTT99", 0, false),
                new Hand("33332", 0, false),
                new Hand("AAAAA", 0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("jokerSource")
    public void handConstructsWithJokers(String cardString, List<Hand.Card> expectedCardList, Hand.HandType expectedType) {
        Hand hand = new Hand(cardString, 10, true);

        assertThat(hand.getCards()).isEqualTo(expectedCardList);
        assertThat(hand.getHandType()).isEqualTo(expectedType);
    }

    public static Stream<Arguments> jokerSource() {
        return Stream.of(
                Arguments.of(
                        "555J5",
                        List.of(FIVE, FIVE, FIVE, JOKER, FIVE),
                        FIVE_OF_A_KIND
                ),
                Arguments.of(
                        "5J5J5",
                        List.of(FIVE, JOKER, FIVE, JOKER, FIVE),
                        FIVE_OF_A_KIND
                ),
                Arguments.of(
                        "5JJJ5",
                        List.of(FIVE, JOKER, JOKER, JOKER, FIVE),
                        FIVE_OF_A_KIND
                ),
                Arguments.of(
                        "JJJJ5",
                        List.of(JOKER, JOKER, JOKER, JOKER, FIVE),
                        FIVE_OF_A_KIND
                ),
                Arguments.of(
                        "JJJJJ",
                        List.of(JOKER, JOKER, JOKER, JOKER, JOKER),
                        FIVE_OF_A_KIND
                )
        );
    }

}