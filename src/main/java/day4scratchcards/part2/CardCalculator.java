package day4scratchcards.part2;

import day4scratchcards.Card;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardCalculator {
    public int calculateCards(List<Card> cardList) {
        Map<Integer, Integer> cardCounts = initializeCardCounts(cardList);

        for (Card card : cardList) {
            int cardMultiplier = cardCounts.get(card.cardId());
            int numWins = calculateWinsOnCard(card);
            for (int i = 1; i <= numWins; i++) {
                int targetCard = card.cardId() + i;
                int previousCount = cardCounts.get(card.cardId() + i);
                int newCount = previousCount + cardMultiplier;
                cardCounts.put(targetCard, newCount);
            }
        }

        return cardCounts.values().stream()
                .mapToInt(val -> val)
                .sum();
    }

    private int calculateWinsOnCard(Card card) {
        return card.yourNumbers().stream()
                .filter(card.winningNumbers()::contains)
                .toList()
                .size();
    }

    private Map<Integer, Integer> initializeCardCounts(List<Card> cardList) {
        return cardList.stream().collect(Collectors.toMap(Card::cardId, card -> 1));
    }
}
