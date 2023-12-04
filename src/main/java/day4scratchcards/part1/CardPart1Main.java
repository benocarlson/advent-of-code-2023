package day4scratchcards.part1;

import day4scratchcards.CardParser;
import utils.ResultPrinter;

public class CardPart1Main {
    private static final String FILE_NAME = "inputFiles/day4scratchcards";
    public static void main(String[] args) {
        CardParser parser = new CardParser();
        CardScorer scorer = new CardScorer();

        ResultPrinter.printResult(FILE_NAME, inputLines -> scorer.scoreCards(parser.parseCards(inputLines)));
    }
}
