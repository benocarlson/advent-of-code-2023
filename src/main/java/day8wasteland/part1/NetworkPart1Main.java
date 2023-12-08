package day8wasteland.part1;

import day8wasteland.NetworkParser;
import utils.ResultPrinter;

public class NetworkPart1Main {
    private static final String FILE_NAME = "inputFiles/day8wasteland";
    public static void main(String[] args) {
        NetworkParser parser = new NetworkParser();

        ResultPrinter.printResult(FILE_NAME, inputLines -> parser.parseNetwork(inputLines).traverse(parser.parseTraversalString(inputLines)));
    }
}
