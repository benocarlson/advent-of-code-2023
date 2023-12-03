package day3gearratios;

import java.util.ArrayList;
import java.util.List;

public class PartNumberParser {

    public List<Integer> parsePartNumbers(List<String> inputLines) {
        List<Integer> partNumbers = new ArrayList<>();
        for (int i = 0; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (Character.isDigit(line.charAt(j))) {
                    int k = j + 1;
                    while(k < line.length() && Character.isDigit(line.charAt(k))) {
                        k++;
                    }
                    if (rangeHasAdjacentSymbol(i, j, k, inputLines)) {
                        partNumbers.add(Integer.parseInt(line.substring(j, k)));
                    }
                    j = k;
                }
            }
        }
        return partNumbers;
    }

    boolean rangeHasAdjacentSymbol(int row, int startColumn, int endColumn, List<String> inputLines) {
        if (row > 0) {
            String aboveRow = inputLines.get(row - 1);
            if (rangeContainsSymbol(startColumn, endColumn, aboveRow)) {
                return true;
            }
        }
        if (startColumn > 0) {
            if (inputLines.get(row).charAt(startColumn - 1) != '.') {
                return true;
            }
        }
        if (endColumn < inputLines.get(row).length()) {
            if (inputLines.get(row).charAt(endColumn) != '.') {
                return true;
            }
        }
        if (row < inputLines.size() - 1) {
            String belowRow = inputLines.get(row + 1);
            return rangeContainsSymbol(startColumn, endColumn, belowRow);
        }
        return false;
    }

    private boolean rangeContainsSymbol(int startColumn, int endColumn, String line) {
        int startIndex = startColumn > 0 ? startColumn - 1 : startColumn;
        int endIndex = endColumn < line.length() ? endColumn + 1 : endColumn;

        for (int i = startIndex; i < endIndex; i++) {
            if (line.charAt(i) != '.') {
                return true;
            }
        }
        return false;
    }
}
