package day8wasteland;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkParser {

    public String parseTraversalString(List<String> inputLines) {
        return inputLines.get(0);
    }

    private static final int KEY_INDEX = 0;
    private static final int LEFT_INDEX = 7;
    private static final int RIGHT_INDEX = 12;

    public Network parseNetwork(List<String> inputLines) {
        Map<String, Network.Fork> netMap = new HashMap<>();
        for (int i = 2; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            String key = line.substring(KEY_INDEX, KEY_INDEX + 3);
            String left = line.substring(LEFT_INDEX, LEFT_INDEX + 3);
            String right = line.substring(RIGHT_INDEX, RIGHT_INDEX + 3);
            netMap.put(key, new Network.Fork(left, right));
        }
        return new Network(netMap);
    }
}
