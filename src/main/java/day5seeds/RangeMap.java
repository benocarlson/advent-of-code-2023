package day5seeds;

import day5seeds.part2.SeedRange;

import java.util.ArrayList;
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

        public RangeClaim getForRange(SeedRange keyRange) {
            List<SeedRange> unclaimedRanges = new ArrayList<>();

            long overlapStart = keyRange.startSeed();
            if (keyRange.startSeed() < keyStart) {
                overlapStart = keyStart;
                unclaimedRanges.add(new SeedRange(keyRange.startSeed(), keyStart - keyRange.startSeed()));
            }
            long overlapEnd = keyRange.startSeed() + keyRange.rangeLength();
            if (overlapEnd > keyStart + rangeLength) {
                overlapEnd = keyStart + rangeLength;
                unclaimedRanges.add(new SeedRange(overlapEnd, keyRange.startSeed() + keyRange.rangeLength() - overlapEnd));
            }
            long overlapLength = overlapEnd - overlapStart;

            if (overlapLength > 0) {
                return new RangeClaim(new SeedRange(get(overlapStart), overlapLength), unclaimedRanges);
            }
            else {
                return new RangeClaim(null, List.of(keyRange));
            }

        }

        public record RangeClaim(SeedRange valueRange, List<SeedRange> unclaimedRanges){}

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

    public List<SeedRange> getForRanges(List<SeedRange> keyRanges) {
        List<SeedRange> valueRanges = new ArrayList<>();
        List<SeedRange> unclaimedRanges = new ArrayList<>(keyRanges);

        for (MapRange mapRange : this.mapRanges) {
            List<SeedRange> unclaimedThisPass = new ArrayList<>();
            for (SeedRange range : unclaimedRanges) {
                MapRange.RangeClaim claim = mapRange.getForRange(range);
                if (claim.valueRange != null) {
                    valueRanges.add(claim.valueRange);
                }
                if (!claim.unclaimedRanges.isEmpty()) {
                    unclaimedThisPass.addAll(claim.unclaimedRanges);
                }
            }
            unclaimedRanges = unclaimedThisPass;
        }

        valueRanges.addAll(unclaimedRanges);

        return valueRanges;
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
