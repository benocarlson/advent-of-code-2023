package utils;

import java.io.FileNotFoundException;
import java.util.List;

public class ResultPrinter {
    public static void printResult(String fileName, PuzzleSolver puzzleSolver) {
        try {
            List<String> inputLines = FileUtils.getLinesFromFile(fileName);
            int solution = puzzleSolver.getSolution(inputLines);
            System.out.println("Result: " + solution);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }

    public static void printLongResult(String fileName, LongPuzzleSolver longPuzzleSolver) {
        try {
            List<String> inputLines = FileUtils.getLinesFromFile(fileName);
            long solution = longPuzzleSolver.getSolution(inputLines);
            System.out.println("Result: " + solution);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }
}
