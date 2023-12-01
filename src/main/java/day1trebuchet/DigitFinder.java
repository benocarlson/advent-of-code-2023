package day1trebuchet;

public class DigitFinder {

    private static Character findFirstDigit(String inputString) {
        for (Character c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return null;
    }

    private static Character findLastDigit(String inputString) {
        String reverseInputString = new StringBuilder(inputString).reverse().toString();
        for (Character c : reverseInputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return null;
    }

    public static int getValueForString(String inputString) throws IllegalArgumentException {
        Character first = findFirstDigit(inputString);
        Character last = findLastDigit(inputString);

        if (first == null || last == null) {
            throw new IllegalArgumentException("No digit found in string");
        }

        String number = new String(new char[] {first, last});

        return Integer.parseInt(number);
    }
}
