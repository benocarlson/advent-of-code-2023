package day1trebuchet;

import java.io.FileNotFoundException;

public class TrebuchetMain {

    public static void main(String[] args) {
        String fileName = "inputFiles/day1trebuchet.txt";
        TrebuchetCalculator calculator = new TrebuchetCalculator();
        try {
            System.out.println(calculator.calculateFromFile(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }
}
