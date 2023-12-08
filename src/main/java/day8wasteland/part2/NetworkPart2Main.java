package day8wasteland.part2;

import day8wasteland.NetworkParser;
import utils.ResultPrinter;

public class NetworkPart2Main {
    private static final String FILE_NAME = "inputFiles/day8wasteland";
    public static void main(String[] args) {
        NetworkParser parser = new NetworkParser();

        ResultPrinter.printLongResult(FILE_NAME, inputLines -> parser.parseNetwork(inputLines).traverseAsGhost(parser.parseTraversalString(inputLines)));
    }
}
