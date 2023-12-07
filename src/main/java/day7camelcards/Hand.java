package day7camelcards;

import java.util.*;

public class Hand implements Comparable<Hand> {

    private static final int HAND_SIZE = 5;

    public enum HandType {
        FIVE_OF_A_KIND(7),
        FOUR_OF_A_KIND(6),
        FULL_HOUSE(5),
        THREE_OF_A_KIND(4),
        TWO_PAIR(3),
        ONE_PAIR(2),
        HIGH_CARD(1);

        final int rank;
        HandType(int rank) {
            this.rank = rank;
        }
    }

    public enum Card {
        ACE('A', 13),
        KING('K', 12),
        QUEEN('Q', 11),
        JACK('J', 10),
        TEN('T', 9),
        NINE('9', 8),
        EIGHT('8', 7),
        SEVEN('7', 6),
        SIX('6', 5),
        FIVE('5', 4),
        FOUR('4', 3),
        THREE('3', 2),
        TWO('2', 1);

        final char id;
        final int strength;
        Card(char id, int strength) {
            this.id = id;
            this.strength = strength;
        }

        public static Card byId(char id) {
            return Arrays.stream(Card.values())
                    .filter(card -> card.id == id)
                    .findFirst()
                    .orElseThrow();
        }
    }

    private final HandType handType;
    private final List<Card> cards;
    private final int bid;

    public Hand(String cardString, int bid) {
        if (cardString.length() != HAND_SIZE) {
            throw new IllegalArgumentException("Invalid card string");
        }
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < HAND_SIZE; i++) {
            cards.add(Card.byId(cardString.charAt(i)));
        }
        this.handType = calculateHandType(cards);
        this.cards = cards;
        this.bid = bid;
    }

    @Override
    public int compareTo(Hand o) {
        int rankComparison = this.handType.rank - o.handType.rank;
        if (rankComparison == 0) {
            for (int i = 0; i < HAND_SIZE; i++) {
                int strengthComparison = this.cards.get(i).strength - o.cards.get(i).strength;
                if (strengthComparison != 0) {
                    return strengthComparison;
                }
            }
        }
        return rankComparison;
    }

    public int getBid() {
        return bid;
    }

    public List<Card> getCards() {
        return cards;
    }

    public HandType getHandType() {
        return handType;
    }

    private static HandType calculateHandType(List<Card> cards) {
        Map<Card, Integer> cardCounts = new HashMap<>();
        for (Card card : cards) {
            cardCounts.putIfAbsent(card, 0);
            cardCounts.put(card, cardCounts.get(card) + 1);
        }
        if (isFiveOfAKind(cardCounts.values())) {
            return HandType.FIVE_OF_A_KIND;
        }
        if (isFourOfAKind(cardCounts.values())) {
            return HandType.FOUR_OF_A_KIND;
        }
        if (isFullHouse(cardCounts.values())) {
            return HandType.FULL_HOUSE;
        }
        if (isThreeOfAKind(cardCounts.values())) {
            return HandType.THREE_OF_A_KIND;
        }
        if (isTwoPair(cardCounts.values())) {
            return HandType.TWO_PAIR;
        }
        if (isOnePair(cardCounts.values())) {
            return HandType.ONE_PAIR;
        }
        return HandType.HIGH_CARD;
    }

    private static boolean isFiveOfAKind(Collection<Integer> cardCounts) {
        return cardCounts.contains(5);
    }
    private static boolean isFourOfAKind(Collection<Integer> cardCounts) {
        return cardCounts.contains(4);
    }
    private static boolean isFullHouse(Collection<Integer> cardCounts) {
        return cardCounts.contains(3) && cardCounts.contains(2);
    }
    private static boolean isThreeOfAKind(Collection<Integer> cardCounts) {
        return cardCounts.contains(3) && !cardCounts.contains(2);
    }
    private static boolean isTwoPair(Collection<Integer> cardCounts) {
        return cardCounts.size() == 3 && cardCounts.contains(2);
    }
    private static boolean isOnePair(Collection<Integer> cardCounts) {
        return cardCounts.size() == 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return bid == hand.bid && handType == hand.handType && Objects.equals(cards, hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(handType, cards, bid);
    }
}
