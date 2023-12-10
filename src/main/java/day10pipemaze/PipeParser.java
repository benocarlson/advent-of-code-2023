package day10pipemaze;

import java.util.List;

public class PipeParser {
    public Pipe[][] parsePipeMaze(List<String> inputLines) {
        int columns = inputLines.get(0).length();
        int rows = inputLines.size();
        Pipe[][] pipeMaze = new Pipe[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pipeMaze[i][j] = Pipe.forChar(inputLines.get(i).charAt(j));
            }
        }
        return pipeMaze;
    }
}
