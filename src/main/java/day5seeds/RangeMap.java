package day5seeds;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RangeMap {
    public RangeMap(List<MapRange> mapRanges) {
        this.mapRanges = mapRanges;
    }

    public static class MapRange {
        private final Long valueStart;
        private final Long keyStart;
        private final Long rangeLength;

        public MapRange(Long valueStart, Long keyStart, Long rangeLength) {
            this.valueStart = valueStart;
            this.keyStart = keyStart;
            this.rangeLength = rangeLength;
        }

        public boolean hasKey(Long key) {
            return (key - keyStart) >= 0 && (key - keyStart) < rangeLength;
        }

        public Long get(Long key) {
            return (key - keyStart) + valueStart;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapRange mapRange = (MapRange) o;
            return Objects.equals(valueStart, mapRange.valueStart) && Objects.equals(keyStart, mapRange.keyStart) && Objects.equals(rangeLength, mapRange.rangeLength);
        }

        @Override
        public int hashCode() {
            return Objects.hash(valueStart, keyStart, rangeLength);
        }
    }

    private final List<MapRange> mapRanges;

    public long get(long key) {
        Optional<MapRange> targetRange = this.mapRanges.stream()
                .filter(range -> range.hasKey(key))
                .findFirst();

        if (targetRange.isPresent()) {
            return targetRange.get().get(key);
        }
        else {
            return key;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RangeMap rangeMap = (RangeMap) o;
        return Objects.equals(mapRanges, rangeMap.mapRanges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapRanges);
    }
}
