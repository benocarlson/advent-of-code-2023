package day8wasteland;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Network {

    private static final String TARGET = "ZZZ";
    private static final String START = "AAA";
    private final Map<String, Fork> netMap;

    public Network(Map<String, Fork> netMap) {
        this.netMap = netMap;
    }

    public int traverse(String path) {
        String current = START;
        int loopCount = 0;
        while (!current.equals(TARGET)) {
            for (int i = 0; i < path.length(); i++) {
                loopCount++;
                switch (path.charAt(i)) {
                    case 'L' -> current = netMap.get(current).left;
                    case 'R' -> current = netMap.get(current).right;
                    default -> throw new IllegalArgumentException("Invalid traversal path! Contains " + path.charAt(i) + " at position " + i);
                }
                if (current.equals(TARGET)) break;
            }
        }
        return loopCount;
    }

    public long traverseAsGhost(String path) {
        List<String> currentPositions = netMap.keySet()
                .stream()
                .filter(position -> position.endsWith("A"))
                .toList();

        int loopCount = 0;
        while (!allPositionsAreTarget(currentPositions)) {
            for (int i = 0; i < path.length(); i++) {
                loopCount++;
                switch (path.charAt(i)) {
                    case 'L' -> currentPositions = currentPositions.stream().map(position -> netMap.get(position).left).toList();
                    case 'R' -> currentPositions = currentPositions.stream().map(position -> netMap.get(position).right).toList();
                    default -> throw new IllegalArgumentException("Invalid traversal path! Contains " + path.charAt(i) + " at position " + i);
                }
                if (allPositionsAreTarget(currentPositions)) break;
            }
        }
        return loopCount;
    }

    private boolean allPositionsAreTarget(List<String> positions) {
        return positions.stream().allMatch(position -> position.endsWith("Z"));
    }

    public static record Fork(String left, String right) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return Objects.equals(netMap, network.netMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(netMap);
    }
}
