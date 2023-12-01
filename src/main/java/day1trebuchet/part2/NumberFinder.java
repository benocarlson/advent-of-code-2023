package day1trebuchet.part2;

import day1trebuchet.ValueFinder;

import java.util.Map;

public class NumberFinder implements ValueFinder {

    private final Map<String, Integer> substringMap = Map.ofEntries(
            Map.entry("0", 0),
            Map.entry("zero", 0),
            Map.entry("1", 1),
            Map.entry("one", 1),
            Map.entry("2", 2),
            Map.entry("two", 2),
            Map.entry("3", 3),
            Map.entry("three", 3),
            Map.entry("4", 4),
            Map.entry("four", 4),
            Map.entry("5", 5),
            Map.entry("five", 5),
            Map.entry("6", 6),
            Map.entry("six", 6),
            Map.entry("7", 7),
            Map.entry("seven", 7),
            Map.entry("8", 8),
            Map.entry("eight", 8),
            Map.entry("9", 9),
            Map.entry("nine", 9)
    );

    private Integer getFirstNumber(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i; j <= inputString.length(); j++) {
                String substring = inputString.substring(i, j);
                if (substringMap.containsKey(substring)) {
                    return substringMap.get(substring);
                }
            }
        }
        return null;
    }

    private Integer getLastNumber(String inputString) {
        for (int i = inputString.length(); i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                String substring = inputString.substring(j, i);
                if (substringMap.containsKey(substring)) {
                    return substringMap.get(substring);
                }
            }
        }
        return null;
    }

    @Override
    public int getValueForString(String inputString) {
        Integer first = getFirstNumber(inputString);
        Integer last = getLastNumber(inputString);

        if (first == null || last == null) {
            throw new IllegalArgumentException("Could not find any number in string:" + inputString);
        }

        return (first * 10) + last;
    }
}
