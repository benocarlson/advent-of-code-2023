package day1trebuchet.part2;

import day1trebuchet.ValueFinder;

import java.util.Map;

public class NumberFinder implements ValueFinder {

    private final Map<String, Integer> substringMap = Map.ofEntries(
            Map.entry("0", 0),   // this doesn't actually use zero anywhere as far as I can see.
            Map.entry("zero", 0),// they could have made this a lot meaner, and I'd need more unit tests.
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
            Map.entry("nine", 9)   // there's probably already a utility somewhere for mapping spelled out numbers.
    );                                   // maybe I'll go looking for it.
                                         // EDIT: ChatGpt says there isn't a built-in one and actually recommends doing what I did
    private Integer getFirstNumber(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {      // I hate how unreadable this is. Very prone to bugs.
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
        for (int i = inputString.length(); i >= 0; i--) {        // yeah, this one got me at first. Had to add additional
            for (int j = i - 1; j >= 0; j--) {                   // tests because we missed the number in the source file
                String substring = inputString.substring(j, i);  // due to a bug here
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
