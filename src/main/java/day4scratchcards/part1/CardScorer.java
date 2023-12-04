package day4scratchcards.part1;

import day4scratchcards.Card;

import java.util.List;

public class CardScorer {
    public int scoreCards(List<Card> cardList) {
        return cardList.stream()
                .mapToInt(this::scoreCard)
                .sum();
    }

    private int scoreCard(Card card) {
        List<Integer> yourWinningNumbers = card.yourNumbers().stream()
                .filter(card.winningNumbers()::contains)
                .toList();

        return (int) Math.pow(2, yourWinningNumbers.size() - 1);
    }
}
