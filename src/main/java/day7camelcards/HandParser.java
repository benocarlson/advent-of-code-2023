package day7camelcards;

import java.util.ArrayList;
import java.util.List;

public class HandParser {

    public List<Hand> parseHands(List<String> inputLines) {
        List<Hand> handList = new ArrayList<>();
        for (String line : inputLines) {
            handList.add(parseHand(line, false));
        }
        return handList;
    }

    private Hand parseHand(String line, boolean useJokers) {
        String[] parts = line.strip().split("\\s+");
        return new Hand(parts[0], Integer.parseInt(parts[1]), useJokers);
    }

    public List<Hand> parseHandsWithJokers(List<String> inputLines) {
        List<Hand> handList = new ArrayList<>();
        for (String line : inputLines) {
            handList.add(parseHand(line, true));
        }
        return handList;
    }
}
