package day1trebuchet.part1;

import day1trebuchet.ValueFinder;

public class DigitFinder implements ValueFinder {

    private Character findFirstDigit(String inputString) {
        for (Character c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return null;
    }

    private Character findLastDigit(String inputString) {
        String reverseInputString = new StringBuilder(inputString).reverse().toString();
        for (Character c : reverseInputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public int getValueForString(String inputString) {
        Character first = findFirstDigit(inputString);
        Character last = findLastDigit(inputString);

        if (first == null || last == null) {
            throw new IllegalArgumentException("No digit found in string");
        }

        String number = new String(new char[] {first, last});

        return Integer.parseInt(number);
    }
}
