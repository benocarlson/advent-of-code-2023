package day9mirage.part1;

import day9mirage.ValueParser;
import day9mirage.ValuePredictor;
import utils.ResultPrinter;

public class MiragePart1Main {
    private static final String FILE_NAME = "inputFiles/day9mirage";
    public static void main(String[] args) {
        ValuePredictor predictor = new ValuePredictor();
        ValueParser parser = new ValueParser();

        ResultPrinter.printLongResult(FILE_NAME, inputLines -> predictor.sumPredictedNextValues(parser.parseValues(inputLines)));
    }
}
