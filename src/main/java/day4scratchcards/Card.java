package day4scratchcards;

import java.util.List;

public record Card(int cardId, List<Integer> winningNumbers, List<Integer> yourNumbers) {
}
