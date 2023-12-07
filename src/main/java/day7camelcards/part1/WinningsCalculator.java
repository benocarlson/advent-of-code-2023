package day7camelcards.part1;

import day7camelcards.Hand;

import java.util.ArrayList;
import java.util.List;

public class WinningsCalculator {
    public int calculateWinnings(List<Hand> handList) {
        List<Hand> sortedList = new ArrayList<>(handList);
        sortedList.sort(Hand::compareTo);
        int total = 0;
        for (int i = 0; i < sortedList.size(); i++) {
            total += sortedList.get(i).getBid() * (i + 1);
        }
        return total;
    }
}
