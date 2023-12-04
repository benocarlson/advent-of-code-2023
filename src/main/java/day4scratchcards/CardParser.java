package day4scratchcards;

import java.util.Arrays;
import java.util.List;

public class CardParser {

    private static final String PREFIX = "Card ";
    private static final String ID_DELIMITER = ":";
    private static final String WINNING_DELIMITER = "|";

    public List<Card> parseCards(List<String> inputStrings) {
        return inputStrings.stream().map(this::parseLine).toList();
    }

    private Card parseLine(String line) {
        int cardId = Integer.parseInt(line.substring(PREFIX.length(), line.indexOf(ID_DELIMITER)).strip());

        String winningString = line.substring(line.indexOf(ID_DELIMITER) + 1, line.indexOf(WINNING_DELIMITER)).strip();
        String yourString = line.substring(line.indexOf(WINNING_DELIMITER) + 1).strip();

        List<Integer> winningNumbers = Arrays.stream(winningString.split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        List<Integer> yourNumbers = Arrays.stream(yourString.split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        return new Card(cardId, winningNumbers, yourNumbers);
    }
}
