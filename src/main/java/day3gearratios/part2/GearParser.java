package day3gearratios.part2;

import java.util.ArrayList;
import java.util.List;

public class GearParser {
    public List<CandidatePart> parseCandidateParts(List<String> inputLines) {
        List<CandidatePart> candidateParts = new ArrayList<>();
        for (int i = 0; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (Character.isDigit(line.charAt(j))) {
                    int k = j + 1;
                    while(k < line.length() && Character.isDigit(line.charAt(k))) {
                        k++;
                    }
                    CandidatePart.GearCoordinate coordinate = getAdjacentGearSymbol(i, j, k, inputLines);
                    if (coordinate != null) {
                        int partNumber = Integer.parseInt(line.substring(j, k));
                        candidateParts.add(new CandidatePart(partNumber, coordinate));
                    }
                    j = k;
                }
            }
        }
        return candidateParts;
    }

    private CandidatePart.GearCoordinate getAdjacentGearSymbol(int row, int startColumn, int endColumn, List<String> inputLines) {
        if (row > 0) {
            String aboveRow = inputLines.get(row - 1);
            Integer index = findSymbol(startColumn, endColumn, aboveRow);
            if (index != null) {
                return new CandidatePart.GearCoordinate(row - 1, index);
            }
        }
        if (startColumn > 0) {
            if (inputLines.get(row).charAt(startColumn - 1) == '*') {
                return new CandidatePart.GearCoordinate(row, startColumn - 1);
            }
        }
        if (endColumn < inputLines.get(row).length()) {
            if (inputLines.get(row).charAt(endColumn) == '*') {
                return new CandidatePart.GearCoordinate(row, endColumn);
            }
        }
        if (row < inputLines.size() - 1) {
            String belowRow = inputLines.get(row + 1);
            Integer index = findSymbol(startColumn, endColumn, belowRow);
            if (index != null) {
                return new CandidatePart.GearCoordinate(row + 1, index);
            }
        }
        return null;
    }

    private Integer findSymbol(int startColumn, int endColumn, String line) {
        int startIndex = startColumn > 0 ? startColumn - 1 : startColumn;
        int endIndex = endColumn < line.length() ? endColumn + 1 : endColumn;

        for (int i = startIndex; i < endIndex; i++) {
            if (line.charAt(i) == '*') {
                return i;
            }
        }
        return null;
    }
}
