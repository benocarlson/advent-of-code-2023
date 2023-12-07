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
        Hand hand = new Hand(cardString, 10);

        assertThat(hand.getCards()).isEqualTo(expectedCardList);
        assertThat(hand.getHandType()).isEqualTo(expectedType);
    }

    @Test
    public void handsOrderCorrectly() {
        List<Hand> handList = new java.util.ArrayList<>(List.of(
                new Hand("AAAAA", 0),
                new Hand("AKQJT", 0),
                new Hand("AKKJT", 0),
                new Hand("ATTJT", 0),
                new Hand("ATAT6", 0),
                new Hand("33332", 0),
                new Hand("TT999", 0),
                new Hand("23456", 0),
                new Hand("TTT99", 0),
                new Hand("AKQJ9", 0),
                new Hand("ATT4T", 0),
                new Hand("A6AT6", 0)
        ));

        handList.sort(Hand::compareTo);
        assertThat(handList).containsExactly(
                new Hand("23456", 0),
                new Hand("AKQJ9", 0),
                new Hand("AKQJT", 0),
                new Hand("AKKJT", 0),
                new Hand("A6AT6", 0),
                new Hand("ATAT6", 0),
                new Hand("ATT4T", 0),
                new Hand("ATTJT", 0),
                new Hand("TT999", 0),
                new Hand("TTT99", 0),
                new Hand("33332", 0),
                new Hand("AAAAA", 0)
        );
    }

}