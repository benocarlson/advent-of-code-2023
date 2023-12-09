package day9mirage;

import java.util.ArrayList;
import java.util.List;

public class ValuePredictor {

    public long sumPredictedNextValues(List<List<Long>> valueSets) {
        return valueSets.stream()
                .mapToLong(this::predictNextValue)
                .sum();
    }

    long predictNextValue(List<Long> values) {
        if (values.stream().allMatch(val -> val == 0L)) {
            return 0L;
        }

        List<Long> nextValues = new ArrayList<>();
        for (int i = 1; i < values.size(); i++) {
            nextValues.add(values.get(i) - values.get(i - 1));
        }
        return values.get(values.size() - 1) + predictNextValue(nextValues);
    }

    public long sumPredictedPreviousValues(List<List<Long>> valueSets) {
        return valueSets.stream()
                .mapToLong(this::predictPreviousValue)
                .sum();
    }

    long predictPreviousValue(List<Long> values) {
        if (values.stream().allMatch(val -> val == 0L)) {
            return 0L;
        }
        List<Long> nextValues = new ArrayList<>();
        for (int i = 1; i < values.size(); i++) {
            nextValues.add(values.get(i) - values.get(i - 1));
        }
        return values.get(0) - predictPreviousValue(nextValues);
    }
}
