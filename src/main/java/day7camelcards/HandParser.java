package day7camelcards;

import java.util.ArrayList;
import java.util.List;

public class HandParser {

    public List<Hand> parseHands(List<String> inputLines) {
        List<Hand> handList = new ArrayList<>();
        for (String line : inputLines) {
            handList.add(parseHand(line));
        }
        return handList;
    }

    private Hand parseHand(String line) {
        String[] parts = line.strip().split("\\s+");
        return new Hand(parts[0], Integer.parseInt(parts[1]));
    }
}
