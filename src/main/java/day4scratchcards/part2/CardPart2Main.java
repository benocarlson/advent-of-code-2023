package day4scratchcards.part2;

import day4scratchcards.CardParser;
import utils.ResultPrinter;

public class CardPart2Main {
    private static final String FILE_NAME = "inputFiles/day4scratchcards";
    public static void main(String[] args) {
        CardParser parser = new CardParser();
        CardCalculator calculator = new CardCalculator();
        ResultPrinter.printResult(FILE_NAME, inputLines -> calculator.calculateCards(parser.parseCards(inputLines)));
    }
}
