package day10pipemaze.part2;

import day10pipemaze.PipeParser;
import utils.ResultPrinter;

public class PipePart2Main {
    private static final String FILE_NAME = "inputFiles/day10pipemaze";
    public static void main(String[] args) {
        PipeParser parser = new PipeParser();
        MazeDefiner definer = new MazeDefiner();

        ResultPrinter.printResult(FILE_NAME, inputLines -> definer.countInsideTiles(parser.parsePipeMaze(inputLines)));
    }
}
