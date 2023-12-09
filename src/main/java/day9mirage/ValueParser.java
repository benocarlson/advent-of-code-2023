package day9mirage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueParser {

    public List<List<Long>> parseValues(List<String> inputLines) {
        List<List<Long>> values = new ArrayList<>();
        for (String line : inputLines) {
            List<Long> longList = Arrays.stream(line.strip().split("\\s+")).map(Long::parseLong).toList();
            values.add(longList);
        }
        return values;
    }
}
