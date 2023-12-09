package day8wasteland.part2;

import day8wasteland.Network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkTable {
    public record Row(String key, List<Integer> targetHits, String nextKey){}

    private final Map<String, Row> rowMap;
    private final String path;

    public NetworkTable(Map<String, Network.Fork> netMap, String path) {
        this.path = path;
        rowMap = new HashMap<>();
        for (String key : netMap.keySet()) {
            List<Integer> targetHits = new ArrayList<>();
            String current = key;
            for (int i = 0; i < path.length(); i++) {
                if (current.endsWith("Z")) {
                    targetHits.add(i);
                }
                switch (path.charAt(i)) {
                    case 'L' -> current = netMap.get(current).left();
                    case 'R' -> current = netMap.get(current).right();
                    default ->
                            throw new IllegalArgumentException("Invalid traversal path! Contains " + path.charAt(i) + " at position " + i);
                }
            }
            rowMap.put(key, new Row(key, targetHits, current));
        }
    }

    public long stepsToTarget() {
        List<String> currentPositions = rowMap.keySet()
                .stream()
                .filter(position -> position.endsWith("A"))
                .toList();

        int winThisCycle = winThisCycle(currentPositions);
        int cycles = 0;
        while (winThisCycle == -1) {
            currentPositions = currentPositions.stream()
                    .map(rowMap::get)
                    .map(Row::nextKey)
                    .toList();
            cycles++;
            winThisCycle = winThisCycle(currentPositions);
        }

        return ((long)cycles * path.length()) + winThisCycle;
    }

    private int winThisCycle(List<String> positions) {
        return positions.stream()
                .map(rowMap::get)
                .map(Row::targetHits)
                .reduce((listA, listB) -> listA.stream()
                        .filter(listB::contains)
                        .toList())
                .orElseThrow()
                .stream()
                .findFirst()
                .orElse(-1);
    }
}
