package day10pipemaze.part1;

import day10pipemaze.PipeParser;
import utils.ResultPrinter;

public class PipePart1Main {
    private static final String FILE_NAME = "inputFiles/day10pipemaze";
    public static void main(String[] args) {
        PipeParser parser = new PipeParser();
        MazeRunner runner = new MazeRunner();

        ResultPrinter.printResult(FILE_NAME, inputLines -> runner.findDistanceToFarthestPointFromStart(parser.parsePipeMaze(inputLines)));
    }
}
