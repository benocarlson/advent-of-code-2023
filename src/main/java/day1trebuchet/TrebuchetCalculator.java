package day1trebuchet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrebuchetCalculator {

    public int calculateFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        Scanner scanner = new Scanner(file);

        int total = 0;
        while (scanner.hasNextLine()) {
            total += DigitFinder.getValueForString(scanner.nextLine());
        }

        return total;
    }
}
